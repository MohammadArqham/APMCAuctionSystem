package com.terminalx.productservice.model;

import org.springframework.data.annotation.Id;

import java.util.Arrays;


public class fileData {

    @Id
    private String id;

    private String name;
    private String type;
    private String imagePath;

    private byte[] data;

    public fileData() {
    }

    public fileData(String id, String name, String type, String imagePath, byte[] data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
        this.data = data;
    }

    public fileData(String name, String type, String imagePath, byte[] data) {
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return "fileData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
