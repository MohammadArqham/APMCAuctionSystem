package com.terminalx.userservice.dto;

import com.terminalx.userservice.model.Role;

import java.time.LocalDate;

public class userResponce {
    private String username;
    private String fullname;
    private String location;
    private String email;
    private Long phoneNo;
    private LocalDate RegistrationDate;
    private String about;
    private Role role;

    public userResponce() {
    }

    public userResponce(String username, String fullname, String location, String email, Long phoneNo, LocalDate registrationDate, String about, Role role) {
        this.username = username;
        this.fullname = fullname;
        this.location = location;
        this.email = email;
        this.phoneNo = phoneNo;
        RegistrationDate = registrationDate;
        this.about = about;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
