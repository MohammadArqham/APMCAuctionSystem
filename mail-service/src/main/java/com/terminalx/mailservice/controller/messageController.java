package com.terminalx.mailservice.controller;

import com.terminalx.mailservice.loger.Log;
import com.terminalx.mailservice.service.messageService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@RequestMapping("/mail")
@RestController
public class messageController {
    @Autowired
    messageService messageservice;

    Log log = new Log("mail-service","controller","messageController");


    @GetMapping("")
    public String sample(@RequestParam("name") String name){
        return "sample..!" + name;
    }

    @GetMapping("/sendMail")
    public void sendMail(@RequestParam("to") String to,
                         @RequestParam("subject") String subject,
                         @RequestParam("body") String body) throws UnsupportedEncodingException {
        log.log("inside sendMail function");
        messageservice.sendMail(to,subject,body);
    }

    public void sendMailWithAttachments(String to,String subject,String text,String pathToAttachment) throws MessagingException, IOException, MessagingException {
        log.log("inside sendMailWithAttachments method");
        messageservice.sendMailWithAttachments(to,subject,text,pathToAttachment);
    }

}
