package com.hmmk.melkite.web.rest.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SentPayDateFilter {
    private String serviceId;
    private String productId;
    private Long customerSegmentGroup;
    private Instant startDate;
    private Instant endDate;

    public String buildQuery(){
        String  query = "select distinct f from SentPay f where ";
        query = query + " serviceId = '" + serviceId + "'";
        query = query + " and productId = '" + productId + "'";
        query = query + " and customerSegmentGroup = '" + customerSegmentGroup + "'";
        query = query + " and sentTime >= '" + startDate + "'";
        query = query + " and sentTime <= '" + endDate + "'";
        return query;
    }
}
