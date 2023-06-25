package com.terminalx.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fileData")
public class fileData {

    @Id
    private String id;

    private String name;
    private String type;
    private String imagePath;



    public fileData() {
        super();
    }
    public fileData(String id) {
        super();
        this.id = id;
    }
    public fileData(String name, String type, String imagePath) {
        super();
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
    }
    public fileData(String id, String name, String type, String imagePath) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
