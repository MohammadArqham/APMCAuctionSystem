package com.terminalx.auctionservice.dto;

import com.terminalx.auctionservice.model.user;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class bidHistoryResponce {
    @Id
    private String id;
    private auctionResponce auctionItem;
    private float amount;
    private LocalDateTime creationDate;


    public bidHistoryResponce() {
    }

    public bidHistoryResponce(auctionResponce auctionItem, float amount, LocalDateTime creationDate) {
        this.auctionItem = auctionItem;

        this.amount = amount;
        this.creationDate = creationDate;
    }

    public bidHistoryResponce(String id, auctionResponce auctionItem, float amount, LocalDateTime creationDate) {
        this.id = id;
        this.auctionItem = auctionItem;

        this.amount = amount;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public auctionResponce getAuctionItem() {
        return auctionItem;
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

    public void setAuctionItem(auctionResponce auctionItem) {
        this.auctionItem = auctionItem;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "bidHistoryResponce{" +
                "id='" + id + '\'' +
                ", auctionItem=" + auctionItem +
                ", amount=" + amount +
                ", creationDate=" + creationDate +
                '}';
    }
}
