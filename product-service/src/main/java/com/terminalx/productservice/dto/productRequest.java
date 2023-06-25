package com.terminalx.productservice.dto;

import com.terminalx.productservice.model.Category;
import com.terminalx.productservice.model.fileData;
import com.terminalx.productservice.model.user;

import java.time.LocalDate;

public class productRequest {
    private String name;
    private String discription;
    private int reservePrice;
    private float quantity;
    private String category;
    private String producerId;
    private LocalDate creationDate;
    private String productImage;

    public productRequest() {
    }

    public productRequest(String name, String discription, int reservePrice, float quantity, String category, String producerId, LocalDate creationDate, String productImage) {
        this.name = name;
        this.discription = discription;
        this.reservePrice = reservePrice;
        this.quantity = quantity;
        this.category = category;
        this.producerId = producerId;
        this.creationDate = creationDate;
        this.productImage = productImage;
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

    public String getCategory() {
        return category;
    }

    public String getProducerId() {
        return producerId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getProductImage() {
        return productImage;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "productRequest{" +
                "name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", reservePrice=" + reservePrice +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", producerId='" + producerId + '\'' +
                ", creationDate=" + creationDate +
                ", productImage=" + productImage +
                '}';
    }

}
