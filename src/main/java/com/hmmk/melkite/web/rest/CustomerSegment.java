package com.hmmk.melkite.web.rest;

import com.hmmk.melkite.entity.subscription.CustomerSegmentGroup;
import com.hmmk.melkite.web.rest.errors.BadRequestAlertException;
import com.hmmk.melkite.web.rest.vm.CustomerGroupFilter;
import com.hmmk.melkite.web.rest.vm.PageRequestVM;
import com.hmmk.melkite.web.util.ListResponseDTO;
import com.hmmk.melkite.web.util.Paged;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("customer-segment-group")
public class CustomerSegment {

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public RestResponse<ListResponseDTO> getList(
            @BeanParam CustomerGroupFilter customerGroupFilter,
            @BeanParam PageRequestVM pageRequest,
            @Context UriInfo uriInfo) {
        var page = pageRequest.toPage();
        Paged<CustomerSegmentGroup> result;
        result = new Paged<>(CustomerSegmentGroup.find(customerGroupFilter.buildQuery()).page(page));
        return RestResponse.ResponseBuilder.ok(new ListResponseDTO(result.content, result.totalCount)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public RestResponse<CustomerSegmentGroup> create(CustomerSegmentGroup customerSegmentGroup) throws BadRequestAlertException {
        if (customerSegmentGroup.id != null) {
            throw new BadRequestAlertException("A new customerSegmentGroup cannot already have an ID");
        }
        customerSegmentGroup.persist();
        return RestResponse.ResponseBuilder.create(RestResponse.Status.CREATED, customerSegmentGroup).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public RestResponse<CustomerSegmentGroup> update(CustomerSegmentGroup customerSegmentGroup) throws BadRequestAlertException {
        if (customerSegmentGroup.id == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        customerSegmentGroup.persist();
        return RestResponse.ResponseBuilder.ok(customerSegmentGroup).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public RestResponse<Void> delete(@PathParam("id") Long id) {
        CustomerSegmentGroup.deleteById(id);
        // todo check if there is phone number associated with this group
        return RestResponse.noContent();
    }

}
