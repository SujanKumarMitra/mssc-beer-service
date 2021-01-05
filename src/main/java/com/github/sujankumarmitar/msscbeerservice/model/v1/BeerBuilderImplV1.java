package com.github.sujankumarmitar.msscbeerservice.model.v1;

import com.github.sujankumarmitar.msscbeerservice.util.v1.BeerUtilsV1;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class BeerBuilderImplV1 implements BeerBuilderV1 {
    protected final MutableBeerV1 beer;

    private BeerBuilderImplV1() {
        this.beer = new MutableBeerV1();
    }

    public BeerBuilderV1 builder() {
        return new BeerBuilderImplV1();
    }

    @Override
    public BeerBuilderV1 withId(String id) {
        beer.setId(id);
        return this;
    }

    @Override
    public BeerBuilderV1 withName(String name) {
        beer.setName(name);
        return this;
    }

    @Override
    public BeerBuilderV1 withStyle(BeerStyleV1 style) {
        beer.setStyle(style);
        return this;
    }

    @Override
    public BeerBuilderV1 withUpc(Long upc) {
        beer.setUpc(upc);
        return this;
    }

    @Override
    public BeerBuilderV1 withPrice(BigDecimal price) {
        beer.setPrice(price);
        return this;
    }

    @Override
    public BeerBuilderV1 withQuantityOnHand(Integer quantityOnHand) {
        beer.setQuantityOnHand(quantityOnHand);
        return this;
    }

    @Override
    public BeerBuilderV1 withCreatedAt(ZonedDateTime createdAt) {
        beer.setCreatedAt(createdAt);
        return this;
    }

    @Override
    public BeerBuilderV1 withLastModifiedAt(ZonedDateTime lastModifiedAt) {
        beer.setLastModifiedAt(lastModifiedAt);
        return this;
    }

    @Override
    public BeerV1 build() {
        return beer;
    }

    private class MutableBeerV1 implements BeerV1 {

        private String id;
        private String name;
        private BeerStyleV1 style;
        private Long upc;
        private BigDecimal price;
        private Integer quantityOnHand;
        private ZonedDateTime createdAt;
        private ZonedDateTime lastModifiedAt;

        public MutableBeerV1() {
        }

        public MutableBeerV1(BeerV1 beer) {
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

        public MutableBeerV1(String id,
                             String name,
                             BeerStyleV1 style,
                             Long upc,
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

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public BeerStyleV1 getStyle() {
            return style;
        }

        public void setStyle(BeerStyleV1 style) {
            this.style = style;
        }

        @Override
        public Long getUpc() {
            return upc;
        }

        public void setUpc(Long upc) {
            this.upc = upc;
        }

        @Override
        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public Integer getQuantityOnHand() {
            return quantityOnHand;
        }

        public void setQuantityOnHand(Integer quantityOnHand) {
            this.quantityOnHand = quantityOnHand;
        }

        @Override
        public ZonedDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
        }

        @Override
        public ZonedDateTime getLastModifiedAt() {
            return lastModifiedAt;
        }

        public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
            this.lastModifiedAt = lastModifiedAt;
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

}
