package com.terminalx.auctionservice.dto;

import com.terminalx.auctionservice.model.Product;
import com.terminalx.auctionservice.model.bid;

import java.time.LocalDateTime;
import java.util.List;

public class auctionResponce {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isClosed;

    private Product product;

    private List<bidResponce> bids;

    public auctionResponce() {
    }

    public auctionResponce(LocalDateTime startTime, LocalDateTime endTime, Boolean isClosed, Product product, List<bidResponce> bids) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isClosed = isClosed;
        this.product = product;
        this.bids = bids;
    }

    public auctionResponce(String id, LocalDateTime startTime, LocalDateTime endTime, Boolean isClosed, Product product, List<bidResponce> bids) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isClosed = isClosed;
        this.product = product;
        this.bids = bids;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public Product getProduct() {
        return product;
    }

    public List<bidResponce> getBids() {
        return bids;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBids(List<bidResponce> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "auctionResponce{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isClosed=" + isClosed +
                ", product=" + product +
                ", bids=" + bids +
                '}';
    }

}
