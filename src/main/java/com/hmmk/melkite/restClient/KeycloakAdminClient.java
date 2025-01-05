package com.hmmk.melkite.restClient;

import com.hmmk.melkite.dto.User;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/admin/realms/{realm}/users")
public interface KeycloakAdminClient {

    @POST
    Response createUser(User user);
}
