package com.hmmk.melkite.web.rest.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailySubscriptionFilter {
    private String serviceId;
    private String productId;
    private String currentCustomerGroupId;
    private Instant from;
    private Instant to;
    public String buildQuery(){
        String  query = "select distinct f from DailySubscription f where ";
        query = query + " serviceId = '" + serviceId + "'";
        query = query + " and productId = '" + productId + "'";
        query = query + " and currentCustomerSegmentGroup = '" + currentCustomerGroupId + "'";
        query = query + " and createdAt >= '" + from + "'";
        query = query + " and createdAt <= '" + to + "'";
        return query;
    }
}
