package com.github.sujankumarmitar.msscbeerservice.dto.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

public class CreateNewBeerResponseV1 {
    private BeerV1 createdBeer;

    public CreateNewBeerResponseV1() {
    }

    public CreateNewBeerResponseV1(BeerV1 createdBeer) {
        this.createdBeer = createdBeer;
    }

    public BeerV1 getCreatedBeer() {
        return createdBeer;
    }
}
