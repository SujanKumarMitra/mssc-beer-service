package com.github.sujankumarmitar.msscbeerservice.service.v1;

import com.github.sujankumarmitar.msscbeerservice.exception.v1.BeerNotFoundExceptionV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

import java.time.ZoneId;

public interface BeerServiceV1 {

    BeerV1 getBeer(String beerId) throws BeerNotFoundExceptionV1;

    BeerV1 createBeer(ZoneId zoneId, BeerV1 beerToCreate);

    void updateBeer(ZoneId zoneId, BeerV1 beerToUpdate) throws BeerNotFoundExceptionV1;

    void deleteBeer(String beerId) throws BeerNotFoundExceptionV1;
}