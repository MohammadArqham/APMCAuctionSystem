package com.terminalx.userservice.config;


import com.terminalx.userservice.client.mailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


public class WebClientConfig {

//    @Autowired
//    private LoadBalancedExchangeFilterFunction filterFunction;
//
//
//    @Bean
//    public WebClient mailWebClient() {
//        return WebClient.builder()
//                .baseUrl("http://mail-service")
//                .filter(filterFunction)
//                .build();
//    }
//
//    @Bean
//    public mailClient mailClient() {
//        HttpServiceProxyFactory httpServiceProxyFactory
//                = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(mailWebClient()))
//                .build();
//        return httpServiceProxyFactory.createClient(mailClient.class);
//    }
}