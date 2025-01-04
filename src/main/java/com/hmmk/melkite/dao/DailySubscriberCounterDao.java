package com.hmmk.melkite.dao;


import com.hmmk.melkite.dto.WebServiceQueueItem;
import com.hmmk.melkite.entity.subscription.CustomerSegmentGroup;
import com.hmmk.melkite.entity.subscription.DailySubscriberCounter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@ApplicationScoped
public class DailySubscriberCounterDao {

    @Inject
    CustomerSegmentGroupDao customerSegmentGroupDao;

    public DailySubscriberCounter findByServiceIdAndProductIdAndCurrentCustomerSegmentGroup(String serviceId, String productId, String currentCustomerSegmentGroup, String atDateOf) {
        return DailySubscriberCounter.find("serviceId = ?1 and productId = ?2 and currentCustomerSegmentGroup = ?3 and atDateOf = ?4", serviceId, productId, currentCustomerSegmentGroup, atDateOf).firstResult();
    }
    public void createOrUpdate(WebServiceQueueItem webServiceQueueItem) {
        CustomerSegmentGroup activeByServiceIdAndProductId = customerSegmentGroupDao.findActiveByServiceIdAndProductId(webServiceQueueItem.getServiceId(), webServiceQueueItem.getProductId());
        DailySubscriberCounter byServiceIdAndProductIdAndCurrentCustomerSegmentGroup = findByServiceIdAndProductIdAndCurrentCustomerSegmentGroup(webServiceQueueItem.getServiceId(), webServiceQueueItem.getProductId(), activeByServiceIdAndProductId.customerSegmentGroupName, Instant.now().truncatedTo(ChronoUnit.DAYS).toString());
        if (byServiceIdAndProductIdAndCurrentCustomerSegmentGroup == null) {
            DailySubscriberCounter dailySubscriberCounter = new DailySubscriberCounter();
            dailySubscriberCounter.serviceId = webServiceQueueItem.getServiceId();
            dailySubscriberCounter.productId = webServiceQueueItem.getProductId();
            dailySubscriberCounter.currentCustomerSegmentGroup = activeByServiceIdAndProductId.id;
            dailySubscriberCounter.subscriberCount = 0;
            dailySubscriberCounter.unSubscriberCount = 0;
            byServiceIdAndProductIdAndCurrentCustomerSegmentGroup = dailySubscriberCounter;
        }
        if (webServiceQueueItem.getUpdateType().equalsIgnoreCase("ok")){
            byServiceIdAndProductIdAndCurrentCustomerSegmentGroup.subscriberCount = byServiceIdAndProductIdAndCurrentCustomerSegmentGroup.subscriberCount + 1;
        } else {
            byServiceIdAndProductIdAndCurrentCustomerSegmentGroup.unSubscriberCount = byServiceIdAndProductIdAndCurrentCustomerSegmentGroup.unSubscriberCount + 1;
        }
        byServiceIdAndProductIdAndCurrentCustomerSegmentGroup.persistAndFlush();
    }
}
