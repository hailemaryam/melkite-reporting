package com.hmmk.melkite.scheduled;

import com.hmmk.melkite.dao.CustomerSegmentGroupDao;
import com.hmmk.melkite.dto.SendPayItem;
import com.hmmk.melkite.entity.charging.SentPay;
import com.hmmk.melkite.entity.charging.SentPayList;
import com.hmmk.melkite.entity.company.CompanyDetail;
import com.hmmk.melkite.entity.subscription.CustomerSegmentGroup;
import com.hmmk.melkite.entity.subscription.PhoneList;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PublishNewDayCharging {
    @Inject
    CustomerSegmentGroupDao customerSegmentGroupDao;
    @Inject
    @Channel("chargeable-item")
    Emitter<SendPayItem> chargeableItem;

    @Scheduled(cron = "0 0 0 * * ?")
    public void publishNewDayCharging() throws InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        List<CompanyDetail> allCompany = CompanyDetail.listAll();
        for (CompanyDetail companyDetail : allCompany) {
            List<CustomerSegmentGroup> allCustomerSegmentByServiceIdAndProductId = customerSegmentGroupDao.findAllByServiceIdAndProductId(companyDetail.serviceId, companyDetail.productId);
            for (CustomerSegmentGroup customerSegmentGroup : allCustomerSegmentByServiceIdAndProductId) {
                executorService.submit(() -> {

                });
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
    SendPayItem toSenPayItem(PhoneList phoneList, String spId, String hash){
        SendPayItem sendPayItem = new SendPayItem();
        sendPayItem.setAtDateOf(Instant.now().truncatedTo(ChronoUnit.DAYS).toString());
        sendPayItem.setSpId(spId);
        sendPayItem.setHash(hash);
        sendPayItem.setServiceId(phoneList.serviceId);
        sendPayItem.setProductId(phoneList.productId);
        sendPayItem.setPhone(phoneList.phone);
        sendPayItem.setCustomerSegmentGroup(phoneList.customerSegmentGroup);
        sendPayItem.setSentPayId(
                phoneList.serviceId +
                phoneList.productId +
                Instant.now().truncatedTo(ChronoUnit.DAYS).toString() +
                phoneList.customerSegmentGroup);
        sendPayItem.setSendPayListId(
                Instant.now().truncatedTo(ChronoUnit.DAYS).toString() + phoneList.id);
        sendPayItem.setStatus(false);
        return sendPayItem;
    }
    SentPayList toSentPayList(SendPayItem sendPayItem){
        SentPayList sentPayList = new SentPayList();
        sentPayList.id = sendPayItem.getSendPayListId();
        sentPayList.serviceId = sendPayItem.getServiceId();
        sentPayList.productId = sendPayItem.getProductId();
        sentPayList.sentPayId = sendPayItem.getSentPayId();
    }

}
