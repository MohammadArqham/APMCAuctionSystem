package com.terminalx.productservice.service;

import com.terminalx.productservice.model.user;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class apiService {

    public user getUserById(String id){
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(String.format("http://localhost:8081/user/getById/%s",id));

        return WebClient.builder().build()
                .get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(user.class)
                .block();



    }
}
