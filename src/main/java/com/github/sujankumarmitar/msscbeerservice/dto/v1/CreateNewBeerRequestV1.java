package com.github.sujankumarmitar.msscbeerservice.dto.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class CreateNewBeerRequestV1 implements BeerV1 {

    private String name;
    private BeerStyleV1 style;
    private String upc;
    private BigDecimal price;
    private Integer quantityOnHand;

    public CreateNewBeerRequestV1() {
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public ZonedDateTime getCreatedAt() {
        return null;
    }

    @Override
    public ZonedDateTime getLastModifiedAt() {
        return null;
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
    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
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
}
