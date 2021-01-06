package com.github.sujankumarmitar.msscbeerservice.exception.v1;

import java.text.MessageFormat;

import static java.text.MessageFormat.format;

public class BeerNotFoundExceptionV1 extends RuntimeException {

    protected final String beerId;

    public BeerNotFoundExceptionV1(String beerId) {
        super(format("Beer with id [{0}] not found",beerId));
        this.beerId = beerId;
    }

    public String getBeerId() {
        return beerId;
    }
}
