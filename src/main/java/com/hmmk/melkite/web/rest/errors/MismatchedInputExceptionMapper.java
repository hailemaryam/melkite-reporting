package com.hmmk.melkite.web.rest.errors;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.stream.Collectors;

import static jakarta.ws.rs.core.Response.status;
@Provider
public class MismatchedInputExceptionMapper implements ExceptionMapper<MismatchedInputException> {
    @Override
    public Response toResponse(MismatchedInputException exception) {
        //get the specific field that has the error
        String fieldPath = getFieldPath(exception);
        return status(Response.Status.BAD_REQUEST).entity(new ErrMessage("Bad Request", fieldPath +" " + "has error")).build();
    }

  private String getFieldPath(MismatchedInputException exception) {
        return exception.getPath().stream()
                .map(ref-> ref.getFieldName())
                .collect(Collectors.joining("."));
}}