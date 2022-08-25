package com.example.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ShopWebClient API", version = "1.0", description = "ShopWebClient microservice"))
@Slf4j
@EnableScheduling
public class WebClientApplication {

    public static void main(String[] args) {

		SpringApplication.run(WebClientApplication.class, args);
		System.out.println("test");
		log.info("test2");
		log.info("test3");
		log.info("test4");

	}
}
