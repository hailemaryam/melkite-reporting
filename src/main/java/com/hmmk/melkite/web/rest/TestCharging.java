package com.hmmk.melkite.web.rest;

import com.hmmk.melkite.dto.SendPayItem;
import com.hmmk.melkite.restClient.TestRestClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/test")
@RegisterRestClient(configKey = "charging-api")
public class TestCharging {
    @Inject
    @RestClient
    TestRestClient testRestClient;

    @POST
    @Path("pay")
    @Consumes("application/json")
    @Produces("application/json")
    public String sendPay(SendPayItem sendPayItem){
        return testRestClient.sendPay(sendPayItem);
    }
}
