package com.hmmk.melkite.web.rest.vm;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneListFilter {
    @QueryParam("serviceId")
    private String serviceId;
    @QueryParam("productId")
    private String productId;
    @QueryParam("customerSegmentGroup")
    private Long customerSegmentGroup;

    public String buildQuery(){
        String  query = "select distinct f from PhoneList f where ";
        query = query + " serviceId = '" + serviceId + "'";
        query = query + " and productId = '" + productId + "'";
        query = query + " and customerSegmentGroup = '" + customerSegmentGroup + "'";
        return query;
    }
}
