package com.hmmk.melkite.web.rest.vm;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SentPayListFilter {
    @QueryParam("serviceId")
    private String serviceId;
    @QueryParam("productId")
    private String productId;
    @QueryParam("sentPayId")
    private String sentPayId;

    public String buildQuery(){
        String  query = "select distinct f from SentPay f where ";
        query = query + " serviceId = '" + serviceId + "'";
        query = query + " and productId = '" + productId + "'";
        query = query + " and sentPayId = '" + sentPayId + "'";
        return query;
    }
}
