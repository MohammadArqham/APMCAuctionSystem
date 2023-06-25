package com.terminalx.auctionservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "watchlist")
public class watchlist {
    @Id
    private String id;
    private String userId;
    private String auctionId;

    public watchlist() {
    }

    public watchlist(String userId, String auctionId) {
        this.userId = userId;
        this.auctionId = auctionId;
    }

    public watchlist(String id, String userId, String auctionId) {
        this.id = id;
        this.userId = userId;
        this.auctionId = auctionId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public String toString() {
        return "watchlist{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", auctionId='" + auctionId + '\'' +
                '}';
    }
}
