package com.myapp.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category> categories;

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }
    public void addOrders(OrderEntity o)
    {
        this.orders.add(o);
    }

    @ManyToMany(mappedBy = "cars",cascade = CascadeType.ALL)
    private Set<OrderEntity>orders;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    public void addCategories(Category c)
    {
        this.categories.add(c);
        //return this.categories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
