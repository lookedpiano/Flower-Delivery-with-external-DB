package com.udacity.flowerdelivery.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
public class Flower extends Plant {

    private String color;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
