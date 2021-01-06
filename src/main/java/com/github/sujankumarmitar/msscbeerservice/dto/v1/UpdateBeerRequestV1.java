package com.github.sujankumarmitar.msscbeerservice.dto.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class UpdateBeerRequestV1 implements BeerV1 {

    private String id;

    @NotBlank(message = "name can't be blank")
    private String name;

    @NotNull(message = "style can't be null")
    private BeerStyleV1 style;

    @PositiveOrZero(message = "price can't be negative")
    private BigDecimal price;

    @PositiveOrZero(message = "quantity can't be negative")
    private Integer quantityOnHand;

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
    public String getUpc() {
        return null;
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
        return null;
    }

    @Override
    public ZonedDateTime getLastModifiedAt() {
        return null;
    }
}
