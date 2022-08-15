package com.example.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ShopWebClient API", version = "1.0", description = "ShopWebClient microservice"))
public class WebClientApplication {

    public static void main(String[] args) {
		WebClientService webClientService;

		SpringApplication.run(WebClientApplication.class, args);
		System.out.println("test");


	}
}
