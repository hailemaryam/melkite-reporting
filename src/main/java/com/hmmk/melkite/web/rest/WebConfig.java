package com.hmmk.melkite.web.rest;


import com.hmmk.melkite.dto.WebConfigItem;
import com.hmmk.melkite.restClient.WebConfigRestClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;

@Path("web-config")
public class WebConfig {
    @Inject
    @RestClient
    WebConfigRestClient webConfigRestClient;

    @GET
    @Path("get-web-config")
    @Produces("application/json")
    @Consumes("application/json")
    public RestResponse<WebConfigItem> getWebConfigItem(
            @QueryParam("service-id") String serviceId,
            @QueryParam("product-id") String productId
            ){
        return webConfigRestClient.getWebConfigItem(serviceId, productId);
    }

    @POST
    @Path("get-web-config")
    @Consumes("application/json")
    @Produces("application/json")
    public RestResponse<WebConfigItem> createOrUpdate( WebConfigItem webConfigItem){
        return webConfigRestClient.createOrUpdate(webConfigItem);
    }
}
