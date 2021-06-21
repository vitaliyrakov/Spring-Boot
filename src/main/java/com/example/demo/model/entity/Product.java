package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price_id")
    private Price price;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    List<Order> orders;

    public String getCustomers() {
        return orders.stream()
                .map(o -> o.getCustomer())
                .distinct()
                .map(c -> c.getName())
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
