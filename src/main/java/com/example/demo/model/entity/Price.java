package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cost")
    private double cost;

    @Column(name = "dateP")
    private Date date;

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}