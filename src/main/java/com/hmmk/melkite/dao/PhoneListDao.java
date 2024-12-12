package com.hmmk.melkite.dao;


import com.hmmk.melkite.dto.WebServiceQueueItem;
import com.hmmk.melkite.entity.subscription.CustomerSegmentGroup;
import com.hmmk.melkite.entity.subscription.PhoneList;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PhoneListDao {
    @Inject
    CustomerSegmentGroupDao customerSegmentGroupDao;

    public PhoneList findByServiceIdAndProductId(String serviceId, String productId) {
        return PhoneList.find("serviceId = ?1 and productId = ?2", serviceId, productId).firstResult();
    }
    public void createOrUpdate(WebServiceQueueItem webServiceQueueItem){
        PhoneList byServiceIdAndProductId = findByServiceIdAndProductId(webServiceQueueItem.getServiceId(), webServiceQueueItem.getProductId());
        CustomerSegmentGroup activeByServiceIdAndProductId = customerSegmentGroupDao.findActiveByServiceIdAndProductId(webServiceQueueItem.getServiceId(), webServiceQueueItem.getProductId());
        if (byServiceIdAndProductId == null){
            PhoneList phoneList = new PhoneList();
            phoneList.phone = webServiceQueueItem.getPhone();
            phoneList.customerSegmentGroup = activeByServiceIdAndProductId.customerSegmentGroupName;
            phoneList.serviceId = webServiceQueueItem.getServiceId();
            phoneList.productId = webServiceQueueItem.getProductId();
            phoneList.status = webServiceQueueItem.getUpdateType().equalsIgnoreCase("ok");
        } else {
            byServiceIdAndProductId.status = webServiceQueueItem.getUpdateType().equalsIgnoreCase("ok");
        }
    }
}
