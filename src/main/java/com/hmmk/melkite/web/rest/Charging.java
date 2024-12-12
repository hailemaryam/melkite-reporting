package com.hmmk.melkite.web.rest;

import com.hmmk.melkite.entity.charging.SentPay;
import com.hmmk.melkite.web.rest.vm.PageRequestVM;
import com.hmmk.melkite.web.rest.vm.SentPayDateFilter;
import com.hmmk.melkite.web.rest.vm.SentPayListFilter;
import com.hmmk.melkite.web.rest.vm.SentPayTableFilter;
import com.hmmk.melkite.web.util.ListResponseDTO;
import com.hmmk.melkite.web.util.Paged;
import jakarta.ws.rs.*;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/charging")
public class Charging {

    @POST
    @Path("/get-sent-pay-by-date")
    @Produces("application/json")
    @Consumes("application/json")
    public RestResponse<ListResponseDTO> getSentPayByDateFilter(SentPayDateFilter sentPayDateFilter) {
        Paged<SentPay> result = new Paged<>(SentPay.find(sentPayDateFilter.buildQuery()));
        return RestResponse.ResponseBuilder.ok(new ListResponseDTO(result.content, result.totalCount)).build();
    }

    @GET
    @Path("/get-sent-pay-list-view")
    @Produces("application/json")
    @Consumes("application/json")
    public RestResponse<ListResponseDTO> getSentPayList(
            @BeanParam SentPayTableFilter sentPayTableFilter,
            @BeanParam PageRequestVM pageRequest) {
        var page = pageRequest.toPage();
        Paged<SentPay> result;
        result = new Paged<>(SentPay.find(sentPayTableFilter.buildQuery()).page(page));
        return RestResponse.ResponseBuilder.ok(new ListResponseDTO(result.content, result.totalCount)).build();
    }

    @GET
    @Path("/get-sent-pay-list")
    @Produces("application/json")
    @Consumes("application/json")
    public RestResponse<ListResponseDTO> getSentPayList(
            @BeanParam SentPayListFilter sentPayListFilter,
            @BeanParam PageRequestVM pageRequest) {
        var page = pageRequest.toPage();
        Paged<SentPay> result;
        result = new Paged<>(SentPay.find(sentPayListFilter.buildQuery()).page(page));
        return RestResponse.ResponseBuilder.ok(new ListResponseDTO(result.content, result.totalCount)).build();
    }

}
