package com.github.sujankumarmitar.msscbeerservice.dto.v1;

import com.github.sujankumarmitar.msscbeerservice.exception.v1.BeerNotFoundExceptionV1;

public class BeerNotFoundResponseV1 {

    private String error;
    private String beerId;

    public BeerNotFoundResponseV1() {
    }

    public BeerNotFoundResponseV1(BeerNotFoundExceptionV1 exc) {
        this(exc.getMessage(), exc.getBeerId());
    }

    public BeerNotFoundResponseV1(String error, String beerId) {
        this.error = error;
        this.beerId = beerId;
    }

    public String getError() {
        return error;
    }

    public String getBeerId() {
        return beerId;
    }
}
