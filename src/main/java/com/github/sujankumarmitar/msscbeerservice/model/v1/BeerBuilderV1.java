package com.github.sujankumarmitar.msscbeerservice.model.v1;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public interface BeerBuilderV1 {

    BeerBuilderV1 fromBeer(BeerV1 beer);

    BeerBuilderV1 withId(String id);

    BeerBuilderV1 withName(String name);

    BeerBuilderV1 withStyle(BeerStyleV1 style);

    BeerBuilderV1 withUpc(String upc);

    BeerBuilderV1 withPrice(BigDecimal price);

    BeerBuilderV1 withQuantityOnHand(Integer quantityOnHand);

    BeerBuilderV1 withCreatedAt(ZonedDateTime createdAt);

    BeerBuilderV1 withLastModifiedAt(ZonedDateTime lastModifiedAt);

    BeerV1 build();
}
