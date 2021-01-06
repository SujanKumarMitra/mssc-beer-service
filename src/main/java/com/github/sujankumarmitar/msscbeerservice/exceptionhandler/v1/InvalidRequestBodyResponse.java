package com.github.sujankumarmitar.msscbeerservice.exceptionhandler.v1;

import java.util.Collection;

public class InvalidRequestBodyResponse {

    public final String message;
    public final Collection<RequestBodyError> errors;

    public InvalidRequestBodyResponse(Collection<RequestBodyError> errors) {
        this("Request Body has errors!", errors);
    }

    public InvalidRequestBodyResponse(String message, Collection<RequestBodyError> errors) {
        this.message = message;
        this.errors = errors;
    }

    public Collection<RequestBodyError> getErrors() {
        return errors;
    }
}
