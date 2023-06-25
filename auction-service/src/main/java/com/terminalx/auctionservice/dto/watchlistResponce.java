package com.terminalx.auctionservice.dto;

import org.springframework.data.annotation.Id;

import java.util.List;

public class watchlistResponce {
    private String id;
    private auctionResponce auctions;

    public watchlistResponce() {
    }

    public watchlistResponce(String id, auctionResponce auctions) {
        this.id = id;
        this.auctions = auctions;
    }

    public String getId() {
        return id;
    }

    public auctionResponce getAuctions() {
        return auctions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuctions(auctionResponce auctions) {
        this.auctions = auctions;
    }

    @Override
    public String toString() {
        return "watchlistResponce{" +
                "id='" + id + '\'' +
                ", auctions=" + auctions +
                '}';
    }
}
