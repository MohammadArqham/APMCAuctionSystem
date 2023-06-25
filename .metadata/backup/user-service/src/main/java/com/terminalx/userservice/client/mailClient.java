package com.terminalx.userservice.client;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface mailClient {

    @GetExchange("/mail/sendMail")
    public void sendMail(String to,String subject,String body);

}