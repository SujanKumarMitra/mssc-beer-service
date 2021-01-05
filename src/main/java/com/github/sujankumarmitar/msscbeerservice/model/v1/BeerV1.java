package com.github.sujankumarmitar.msscbeerservice.model.v1;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public interface BeerV1 {

    String getId();

    String getName();

    BeerStyleV1 getStyle();

    Long getUpc();

    BigDecimal getPrice();

    Integer getQuantityOnHand();

    ZonedDateTime getCreatedAt();

    ZonedDateTime getLastModifiedAt();
}
