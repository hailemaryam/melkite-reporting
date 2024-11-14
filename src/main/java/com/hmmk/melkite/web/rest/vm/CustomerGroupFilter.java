package com.hmmk.melkite.web.rest.vm;


import jakarta.ws.rs.QueryParam;
import lombok.Data;

@Data
public class CustomerGroupFilter {
    @QueryParam("productId")
    public String productId;
    @QueryParam("serviceId")
    public String serviceId;
    public String buildQuery(){
        String  query = "select distinct f from CustomerSegmentGroup f where ";
        query = query + " serviceId = '" + serviceId + "'";
        query = query + " and productId = '" + productId + "'";
        return query;
    }
}
