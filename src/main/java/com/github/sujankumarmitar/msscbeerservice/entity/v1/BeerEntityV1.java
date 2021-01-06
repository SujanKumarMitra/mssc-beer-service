package com.github.sujankumarmitar.msscbeerservice.entity.v1;

import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;
import com.github.sujankumarmitar.msscbeerservice.util.v1.BeerUtilsV1;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "beers")
public class BeerEntityV1 implements BeerV1, Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "style")
    @Enumerated(EnumType.STRING)
    private BeerStyleV1 style;

    @Column(name = "upc", unique = true)
    private Long upc;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity_on_hand")
    private Integer quantityOnHand;

    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "last_modified_at")
    private ZonedDateTime lastModifiedAt;

    public BeerEntityV1() {
    }

    public BeerEntityV1(String id,
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

    public BeerEntityV1(BeerV1 beer) {
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
