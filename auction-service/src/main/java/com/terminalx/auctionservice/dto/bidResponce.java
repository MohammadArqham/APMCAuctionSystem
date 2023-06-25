package com.terminalx.auctionservice.dto;

import com.terminalx.auctionservice.model.user;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class bidResponce {
    @Id
    private String id;
    private user bidder;
    private String auctionId;
    private float amount;
    private LocalDateTime creationDate;


    public bidResponce() {
    }

    public bidResponce(user bidder, String productId, float amount, LocalDateTime creationDate) {
        this.bidder = bidder;
        this.auctionId = productId;
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public bidResponce(String id, user bidder, String productId, float amount, LocalDateTime creationDate) {
        this.id = id;
        this.bidder = bidder;
        this.auctionId = productId;
        this.amount = amount;
        this.creationDate = creationDate;
    }



    public String getId() {
        return id;
    }

    public user getBidder() {
        return bidder;
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

    public void setBidder(user bidder) {
        this.bidder = bidder;
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
                ", bidder=" + bidder +
                ", productId='" + auctionId + '\'' +
                ", amount=" + amount +
                ", creationDate=" + creationDate +
                '}';
    }
}

