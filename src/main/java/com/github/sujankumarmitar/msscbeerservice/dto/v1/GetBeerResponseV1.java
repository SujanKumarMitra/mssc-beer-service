package com.github.sujankumarmitar.msscbeerservice.dto.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

public class GetBeerResponseV1 {

    private BeerV1 beer;

    public GetBeerResponseV1(BeerV1 beer) {
        this.beer = beer;
    }

    public BeerV1 getBeer() {
        return beer;
    }
}
