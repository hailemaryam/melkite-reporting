package com.hmmk.melkite.restClient;

import com.hmmk.melkite.dto.SmscConfigItem;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("smsc-config")
@RegisterRestClient(configKey = "sms-config-api")
public interface SmscConfgRestClient {

    @GET
    @Path("get-smsc-config")
    @Produces("application/json")
    @Consumes("application/json")
    SmscConfigItem getSmscConfigItem(
            @QueryParam("service-id") String serviceId,
            @QueryParam("product-id") String productId
    );

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    SmscConfigItem createOrUpdate(SmscConfigItem smscConfigItem);
}
