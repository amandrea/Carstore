package com.myapp.entity;
import javax.persistence.*;
import javax.persistence.Entity;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int cartId;
    @Column
    private int numberOfProducts;
    @Column
    private double totalPrice;

    public int getCartId() {
        return cartId;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
