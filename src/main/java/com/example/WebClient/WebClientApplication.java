package com.example.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ShopWebClient API", version = "1.0", description = "ShopWebClient microservice"))
@Slf4j
public class WebClientApplication {

    public static void main(String[] args) {
		WebClientService webClientService;

		SpringApplication.run(WebClientApplication.class, args);
		System.out.println("test");
		log.info("test2");
		log.info("test3");
		log.info("test4");

	}
}
