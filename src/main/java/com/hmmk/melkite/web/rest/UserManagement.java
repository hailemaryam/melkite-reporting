package com.hmmk.melkite.web.rest;

import com.hmmk.melkite.entity.company.CompanyDetail;
import com.hmmk.melkite.entity.company.UserDetail;
import com.hmmk.melkite.restClient.KeycloakAdminClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("user-management")
public class UserManagement {

    @Inject
    @RestClient
    KeycloakAdminClient keycloakAdminClient;

    // get company list by user id
    @GET
    @Path("get-company-list")
    List<CompanyDetail> getCompanyList(@QueryParam("user-id") Long userId) {
        UserDetail userDetail = UserDetail.findById(userId);
        return userDetail.companies;
    }

    @POST
    @Path("register-user")
    public void registerUser() {

    }
}
