package com.terminalx.mailservice.controller;

import com.terminalx.mailservice.loger.Log;
import com.terminalx.mailservice.service.messageService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;


@RequestMapping("/mail")
@RestController
public class messageController {
    @Autowired
    messageService messageservice;

    Log log = new Log("mail-service","controller","messageController");



    @GetMapping("/sendMail")
    public void sendMail(String to,String subject,String body){
        log.log("inside sendMail function");
        messageservice.sendMail(to,subject,body);
    }

    public void sendMailWithAttachments(String to,String subject,String text,String pathToAttachment) throws MessagingException, IOException, MessagingException {
        log.log("inside sendMailWithAttachments method");
        messageservice.sendMailWithAttachments(to,subject,text,pathToAttachment);
    }

}
