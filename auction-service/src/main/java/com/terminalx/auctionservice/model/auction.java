package com.terminalx.auctionservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "auction")
public class auction {
    @Id
    private String id;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private String productId;
    private Boolean isClosed=false;

    private LocalDateTime creationDate;

    public auction() {
    }

    public auction(LocalDateTime startTime, LocalDateTime endTime, String productId, Boolean isClosed, LocalDateTime creationDate) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.productId = productId;
        this.isClosed = isClosed;
        this.creationDate = creationDate;
    }

    public auction(String id, LocalDateTime startTime, LocalDateTime endTime, String productId, Boolean isClosed, LocalDateTime creationDate) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.productId = productId;
        this.isClosed = isClosed;
        this.creationDate = creationDate;
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

    public String getProductId() {
        return productId;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
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

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "auction{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", productId='" + productId + '\'' +
                ", isClosed=" + isClosed +
                ", creationDate=" + creationDate +
                '}';
    }


}
