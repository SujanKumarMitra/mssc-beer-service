package com.github.sujankumarmitar.msscbeerservice.util.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

import java.util.Objects;

public class BeerUtilsV1 {

    private BeerUtilsV1() {
    }

    public static boolean isEqual(BeerV1 beer1, BeerV1 beer2) {
        if (beer1 == beer2) return true;
        if (beer1 == null || beer2 == null) return false;
        return Objects.equals(beer1.getId(), beer2.getId()) &&
                Objects.equals(beer1.getName(), beer2.getName()) &&
                beer1.getStyle() == beer2.getStyle() &&
                Objects.equals(beer1.getUpc(), beer2.getUpc()) &&
                Objects.equals(beer1.getPrice(), beer2.getPrice()) &&
                Objects.equals(beer1.getQuantityOnHand(), beer2.getQuantityOnHand()) &&
                Objects.equals(beer1.getCreatedAt(), beer2.getCreatedAt()) &&
                Objects.equals(beer1.getLastModifiedAt(), beer2.getLastModifiedAt());
    }

    public static int getHashCode(BeerV1 beer) {
        return Objects.hash(
                beer.getId(),
                beer.getName(),
                beer.getStyle(),
                beer.getUpc(),
                beer.getPrice(),
                beer.getQuantityOnHand(),
                beer.getCreatedAt(),
                beer.getLastModifiedAt());
    }
}

