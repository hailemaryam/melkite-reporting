package com.hmmk.melkite.dao;

import com.hmmk.melkite.entity.subscription.CustomerSegmentGroup;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CustomerSegmentGroupDao {

    public CustomerSegmentGroup findActiveByServiceIdAndProductId(String serviceId, String productId) {
        return CustomerSegmentGroup.find("serviceId = ?1 and productId = ?2 and active = true", serviceId, productId).firstResult();
    }

    public List<CustomerSegmentGroup> findAllByServiceIdAndProductId(String serviceId, String productId) {
        return CustomerSegmentGroup.find("serviceId = ?1 and productId = ?2", serviceId, productId).list();
    }

    public void deactivateOtherByServiceIdAndProductIdAndCustomerSegmentGroupName(String serviceId, String productId, String customerSegmentGroupName) {
        CustomerSegmentGroup.update("active = false", "serviceId = ?1 and productId = ?2 and customerSegmentGroupName != ?3", serviceId, productId, customerSegmentGroupName);
        CustomerSegmentGroup.update("active = true", "serviceId = ?1 and productId = ?2 and customerSegmentGroupName = ?3", serviceId, productId, customerSegmentGroupName);
    }

    public List<CustomerSegmentGroup> findAllCustomerSegmentGroup() {
        return CustomerSegmentGroup.listAll();
    }
}
