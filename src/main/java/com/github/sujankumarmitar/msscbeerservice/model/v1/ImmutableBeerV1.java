package com.github.sujankumarmitar.msscbeerservice.model.v1;

import com.github.sujankumarmitar.msscbeerservice.util.v1.BeerUtilsV1;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ImmutableBeerV1 implements BeerV1 {

    private final String id;
    private final String name;
    private final BeerStyleV1 style;
    private final String upc;
    private final BigDecimal price;
    private final Integer quantityOnHand;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime lastModifiedAt;

    public ImmutableBeerV1(BeerV1 beer) {
        this(
                beer.getId(),
                beer.getName(),
                beer.getStyle(),
                beer.getUpc(),
                beer.getPrice(),
                beer.getQuantityOnHand(),
                beer.getCreatedAt(),
                beer.getLastModifiedAt()
        );
    }

    public ImmutableBeerV1(String id,
                           String name,
                           BeerStyleV1 style,
                           String upc,
                           BigDecimal price,
                           Integer quantityOnHand,
                           ZonedDateTime createdAt,
                           ZonedDateTime lastModifiedAt) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.upc = upc;
        this.price = price;
        this.quantityOnHand = quantityOnHand;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BeerStyleV1 getStyle() {
        return style;
    }

    @Override
    public String getUpc() {
        return upc;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    @Override
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public ZonedDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    @Override
    public String toString() {
        return "BeerV1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", style=" + style +
                ", upc=" + upc +
                ", price=" + price +
                ", quantityOnHand=" + quantityOnHand +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BeerV1))
            return false;
        return BeerUtilsV1.isEqual(this, (BeerV1) o);
    }

    @Override
    public int hashCode() {
        return BeerUtilsV1.getHashCode(this);
    }
}
