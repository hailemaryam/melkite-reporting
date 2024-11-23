package com.hmmk.melkite.restClient;


import com.hmmk.melkite.dto.WebConfigItem;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestResponse;

@Path("web-config")
@RegisterRestClient(configKey = "web-config-api")
public interface WebConfigRestClient {

    @GET
    @Path("get-web-config")
    @Produces("application/json")
    @Consumes("application/json")
    public RestResponse<WebConfigItem> getWebConfigItem(
            @QueryParam("service-id") String serviceId,
            @QueryParam("product-id") String productId
            );

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public RestResponse<WebConfigItem> createOrUpdate( WebConfigItem webConfigItem);
}
