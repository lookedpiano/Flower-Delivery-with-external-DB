package com.udacity.flowerdelivery.entity;


import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.flowerdelivery.view.Views;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

// Uses InheritanceType.JOINED to store shared fields in 'plant' and unique fields in subclass tables
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {

    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision = 12, scale = 4)
    private BigDecimal price; // BigDecimal is the standard Java class for currency math

    //don't retrieve delivery if we don't need it
    @ManyToOne(fetch = FetchType.LAZY) //many plants can belong to one delivery
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    // Convenience Constructor
    public Plant(String name, double price){
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public Plant() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
