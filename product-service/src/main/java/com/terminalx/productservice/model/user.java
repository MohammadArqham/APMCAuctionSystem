package com.terminalx.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

public class user {


    @Id
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String location;
    private String email;
    private Long phoneNo;
    private LocalDate RegistrationDate;
    private String about;

    private String profileImage;

    public user() {
    }

    public user(String username, String password, String fullname, String location, String email, Long phoneNo, LocalDate registrationDate, String about, String profileImage) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.location = location;
        this.email = email;
        this.phoneNo = phoneNo;
        RegistrationDate = registrationDate;
        this.about = about;
        this.profileImage = profileImage;
    }

    public user(String id, String username, String password, String fullname, String location, String email, Long phoneNo, LocalDate registrationDate, String about, String profileImage) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.location = location;
        this.email = email;
        this.phoneNo = phoneNo;
        RegistrationDate = registrationDate;
        this.about = about;
        this.profileImage = profileImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }


    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                ", RegistrationDate=" + RegistrationDate +
                ", about='" + about + '\'' +
                ", profileImage=" + profileImage +
                '}';
    }
}
