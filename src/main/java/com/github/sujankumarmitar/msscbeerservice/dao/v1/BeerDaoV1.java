package com.github.sujankumarmitar.msscbeerservice.dao.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

import java.util.Optional;

public interface BeerDaoV1 {

    Optional<BeerV1> findBeerById(String id);

    BeerV1 createBeer(BeerV1 beer);

    boolean updateBeer(BeerV1 beer);

    boolean deleteBeerById(String id);

}
