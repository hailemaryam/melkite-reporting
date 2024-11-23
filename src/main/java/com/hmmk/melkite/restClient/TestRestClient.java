package com.hmmk.melkite.restClient;

import com.hmmk.melkite.dto.SendPayItem;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/test")
@RegisterRestClient(configKey = "charging-api")
public interface TestRestClient {

    @POST
    @Path("pay")
    @Consumes("application/json")
    @Produces("application/json")
    public String sendPay(SendPayItem sendPayItem);
}
