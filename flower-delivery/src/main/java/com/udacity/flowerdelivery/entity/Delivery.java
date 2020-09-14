package com.udacity.flowerdelivery.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedQuery(name = "Delivery.findByName", query = "select d from Delivery d where d.name = :name")
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Column(name = "address_full", length = 500)
    private String address;

    private LocalDateTime deliveryDateTime;

    @Type(type = "yes_no")
    private boolean completed;

    // added CascadeType.REMOVE to automatically clear any associated plants when removed ::: // changed CascadeType to ALL
    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;


    // Convenience Constructor
    public Delivery(String name, String address, LocalDateTime deliveryTime) {
        this.name = name;
        this.address = address;
        this.deliveryDateTime = deliveryTime;
    }

    public Delivery() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
