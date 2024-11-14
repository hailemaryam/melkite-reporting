package com.hmmk.melkite.web.rest.errors;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RestExceptionHandler implements ExceptionMapper<BadRequestAlertException> {
    @Override
    public Response toResponse(BadRequestAlertException exception){
        return Response.status(Status.BAD_REQUEST).entity(new ErrMessage("Bad Request", exception.getMessage())).build();
    }
}