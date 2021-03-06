package com.github.sujankumarmitar.msscbeerservice.dto.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class CreateNewBeerRequestV1 implements BeerV1 {

    @NotBlank(message = "name can't be blank")
    private String name;

    @NotNull(message = "style can't be null")
    private BeerStyleV1 style;

    @NotBlank
    @Size(min = 13, max = 13, message = "upc code must be 13 digit")
    private String upc;

    @PositiveOrZero(message = "price can't be negative")
    private BigDecimal price;

    @PositiveOrZero(message = "price can't be negative")
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
