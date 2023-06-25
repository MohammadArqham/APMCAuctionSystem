package com.terminalx.auctionservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bid")
public class bid {
    @Id
    private String id;
    private String bidderId;
    private String auctionId;
    private float amount;
    private LocalDateTime creationDate;


    public bid() {
    }

    public bid(String bidderId, String auctionId, float amount, LocalDateTime creationDate) {
        this.bidderId = bidderId;
        this.auctionId = auctionId;
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public bid(String id, String bidderId, String auctionId, float amount, LocalDateTime creationDate) {
        this.id = id;
        this.bidderId = bidderId;
        this.auctionId = auctionId;
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public String getBidderId() {
        return bidderId;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "bid{" +
                "id='" + id + '\'' +
                ", bidderId='" + bidderId + '\'' +
                ", auctionId='" + auctionId + '\'' +
                ", amount=" + amount +
                ", creationDate=" + creationDate +
                '}';
    }

}
