package com.terminalx.mailservice.service;

import com.terminalx.mailservice.loger.Log;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class messageService {
    @Autowired
    private JavaMailSender mailSender;

    Log log = new Log("mail-service","service","messageService");
    public void sendMail(String to,String subject,String body) {

        log.log("inside sendMail method");

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("mohammadarqham182002@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);


        mailSender.send(message);


        System.out.println("mail sent to "+ to + "successfully..!");
    }

    public void sendMailWithAttachments(String to,String subject,String text,String pathToAttachment) throws MessagingException, IOException, MessagingException {

        log.log("inside sendMailWithAttachments method");

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("noreply@baeldung.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file
                = new FileSystemResource(new File(pathToAttachment));


        String fileType = pathToAttachment.substring(pathToAttachment.lastIndexOf("."));


        helper.addAttachment("Invoice"+fileType, file);

        mailSender.send(message);
    }
}
