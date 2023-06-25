package com.terminalx.auctionservice.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Product {
    @Id
    private String id;
    private String name;
    private String discription;
    private int reservePrice;
    private float quantity;
    private Category category;
    private user producer;
    private LocalDate creationDate;
    private String productImage;

    public Product() {
    }

    public Product(String name, String discription, int reservePrice, float quantity, Category category, user producer, LocalDate creationDate, String productImage) {
        this.name = name;
        this.discription = discription;
        this.reservePrice = reservePrice;
        this.quantity = quantity;
        this.category = category;
        this.producer = producer;
        this.creationDate = creationDate;
        this.productImage = productImage;
    }

    public Product(String id, String name, String discription, int reservePrice, float quantity, Category category, user producer, LocalDate creationDate, String productImage) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.reservePrice = reservePrice;
        this.quantity = quantity;
        this.category = category;
        this.producer = producer;
        this.creationDate = creationDate;
        this.productImage = productImage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public float getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public user getProducer() {
        return producer;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProducer(user producer) {
        this.producer = producer;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", reservePrice=" + reservePrice +
                ", quantity=" + quantity +
                ", category=" + category +
                ", producer=" + producer +
                ", creationDate=" + creationDate +
                ", productImage=" + productImage +
                '}';
    }
}


