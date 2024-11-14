package com.hmmk.melkite.web.rest;

import com.hmmk.melkite.entity.subscription.DailySubscriberCounter;
import com.hmmk.melkite.entity.subscription.PhoneList;
import com.hmmk.melkite.web.rest.vm.DailySubscriptionFilter;
import com.hmmk.melkite.web.rest.vm.PageRequestVM;
import com.hmmk.melkite.web.rest.vm.PhoneListFilter;
import com.hmmk.melkite.web.util.ListResponseDTO;
import com.hmmk.melkite.web.util.Paged;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/subscription")
public class Subscription {

    @POST
    @Path("/daily-subscription-counter")
    @Produces("application/json")
    @Consumes("application/json")
    public RestResponse<ListResponseDTO> getDailySubscriptionCounter(DailySubscriptionFilter dailySubscriptionFilter) {
        Paged<DailySubscriberCounter> result = new Paged<>(DailySubscriberCounter.find(dailySubscriptionFilter.buildQuery()));
        return RestResponse.ResponseBuilder.ok(new ListResponseDTO(result.content, result.totalCount)).build();
    }

    @GET
    @Path("/phone-list")
    @Consumes("application/json")
    @Produces("application/json")
    public RestResponse<ListResponseDTO> getPhoneList(
            @BeanParam PhoneListFilter phoneListFilter,
            @BeanParam PageRequestVM pageRequest,
            @Context UriInfo uriInfo) {
        var page = pageRequest.toPage();
        Paged<PhoneList> result;
        result = new Paged<>(PhoneList.find(phoneListFilter.buildQuery()).page(page));
        return RestResponse.ResponseBuilder.ok(new ListResponseDTO(result.content, result.totalCount)).build();
    }


}
