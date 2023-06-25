package com.terminalx.auctionservice.model;

import java.time.LocalDateTime;

public class AuctionItem {
    public String itemId;
    public LocalDateTime endTime;

    public AuctionItem() {
    }

    public AuctionItem(String itemId, LocalDateTime endTime) {
        this.itemId = itemId;
        this.endTime = endTime;
    }

    public String getItemId() {
        return itemId;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "itemId='" + itemId + '\'' +
                ", endTime=" + endTime +
                '}';
    }
}
