package com.terminalx.userservice.service;

import com.terminalx.userservice.dto.userResponce;
import com.terminalx.userservice.loger.Log;
import com.terminalx.userservice.model.user;
import com.terminalx.userservice.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class userService {
    @Autowired
    userRepository userRepo;

    Log log = new Log("user","service","userService");
    public userResponce getOne(String id) {
        log.log("inside getOne");
        user data = userRepo.findById(id).get();
        userResponce responce = new userResponce(data.getUsername(),
                data.getFullname(),
                data.getLocation(),
                data.getEmail(),
                data.getPhoneNo() ,
                data.getRegistrationDate(),
                data.getAbout(),
                data.getRoles());

        return responce;
    }

    public String addOneUser(user d) {
        log.log("inside addOneUser method");
        d.setRegistrationDate(LocalDate.now());
        userRepo.save(d);

        return "item added..!";
    }

    public List<userResponce> getAll() {
        log.log("inside getAll method");
        List<user> userList = userRepo.findAll();

        List<userResponce> Responce = userList.stream().map(
                item-> {

                    userResponce responce = new userResponce(
                            item.getUsername(),
                            item.getFullname(),
                            item.getLocation(),
                            item.getEmail(),
                            item.getPhoneNo() ,
                            item.getRegistrationDate(),
                            item.getAbout(),
                            item.getRoles());

                    return responce;

                }).collect(Collectors.toList());

        return Responce;

    }
}
