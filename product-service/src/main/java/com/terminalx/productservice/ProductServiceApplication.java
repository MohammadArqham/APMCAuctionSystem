package com.terminalx.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;



@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {
	@Bean
	public WebClient webClient(){

		return WebClient.builder().build();
	}


	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
