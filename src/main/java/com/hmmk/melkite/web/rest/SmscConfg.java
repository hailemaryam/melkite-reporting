package com.hmmk.melkite.web.rest;

import com.hmmk.melkite.dto.SmscConfigItem;
import com.hmmk.melkite.restClient.SmscConfgRestClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("smsc-config")
public class SmscConfg {

    @Inject
    @RestClient
    SmscConfgRestClient smscConfgRestClient;

    @GET
    @Path("get-smsc-config")
    @Produces("application/json")
    @Consumes("application/json")
    SmscConfigItem getSmscConfigItem(
            @QueryParam("service-id") String serviceId,
            @QueryParam("product-id") String productId
    ) {
        return smscConfgRestClient.getSmscConfigItem(serviceId, productId);
    }

    @POST
    @Path("get-smsc-config")
    @Consumes("application/json")
    @Produces("application/json")
    SmscConfigItem createOrUpdate(SmscConfigItem smscConfigItem) {
        return smscConfgRestClient.createOrUpdate(smscConfigItem);
    }
}
