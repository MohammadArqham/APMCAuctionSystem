package com.terminalx.auctionservice.service;

import com.terminalx.auctionservice.model.Product;
import com.terminalx.auctionservice.model.user;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class apiService {
    public Product getProductById(String id){
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(String.format("http://localhost:8083/product/getById/%s",id));

        return WebClient.builder().build()
                .get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
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

    public String senMail(String to,String body){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:8082/mail/sendMail")
                .queryParam("to", to)
                .queryParam("subject", "Auction Result")
                .queryParam("body", String.valueOf(body));

        return WebClient.builder().build().get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
