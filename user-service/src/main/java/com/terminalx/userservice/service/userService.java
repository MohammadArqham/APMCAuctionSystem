package com.terminalx.userservice.service;

import com.terminalx.userservice.dto.userResponce;
import com.terminalx.userservice.loger.Log;
import com.terminalx.userservice.model.Role;
import com.terminalx.userservice.model.user;
import com.terminalx.userservice.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userService {
    @Autowired
    userRepository userRepo;

    Log log = new Log("user","service","userService");
    public user getOne(String id) {
        log.log("inside getOne");
        user data = userRepo.findById(id).get();
        return data;
    }

    public String addOneUser(user d) {
        log.log("inside addOneUser method");
        d.setRegistrationDate(LocalDate.now());
        System.out.println(d.toString());
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

    public String authenticate(String username, String password) {
        Optional<user> userById = userRepo.findById(username);
        Optional<user> userByUsername = userRepo.findByUsername(username);
        Optional<user> userByEmail = userRepo.findByEmail(username);

        Optional<user> matchedUser = userById.or(() -> userByUsername).or(() -> userByEmail);

        if (matchedUser.isPresent()) {
            user u = matchedUser.get();
            String storedPassword = u.getPassword();
            // Perform password comparison/validation
            if (storedPassword.equals(password)) {
                // Password matches, authentication successful
                return u.getId();
            } else {
                // Password doesn't match, authentication failed
                System.out.println("password doesn't match..! ");
                return null;
            }
        } else {
            // No user found with the given username, ID, or email
            System.out.println("username/id/email not found..!");
            return null;
        }
    }
}
