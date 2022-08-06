package com.example.WebClient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WebClientService {
    private final WebClient webClient;

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU5ODEzMDMzLCJpYXQiOjE2NTk3NzcwMzN9.d7JzT7yXXgDVW5bJVuwRSQVUHnB4yC1Tz99i6E-fERI";
    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Flux<User> findUsers() {
        return this.webClient.get().uri("/user")
                .headers(h -> h.setBearerAuth(token))
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Mono<User> findUserById(Long id) {
        return this.webClient.get().uri("/user/{id}", id)
                .headers(h -> h.setBearerAuth(token))
                .retrieve()
                .bodyToMono(User.class);
    }

    public Mono<User> saveUser() {
        User user = new User("Ferko2", "testovac2");
        return this.webClient.post().uri("/user")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(user), User.class).retrieve()
                .bodyToMono(User.class);
    }

    public Mono<User> saveUsers() {

        List<User> users = new ArrayList<>();
        users.add(new User("James", "Gosling"));
        users.add(new User("Doug", "Lea"));
        users.add(new User("Martin", "Fowler"));
        users.add(new User("Brian", "Goetz"));
        return this.webClient.post().uri("/user/saveUsersTest")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(users), User.class).retrieve()
                .bodyToMono(User.class);
    }

    public Mono<Statue> saveStatue() {
        Generator generator = new Generator();
        Statue statue = new Statue(generator.socha, 1, generator.weight, generator.length, generator.width, generator.height);
        return this.webClient.post().uri("/statue")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(statue), Statue.class).retrieve()
                .bodyToMono(Statue.class);
    }

    public Mono<Statue> saveStatues() {
        List<Statue> statues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Generator generator = new Generator();
            statues.add(new Statue(generator.socha, generator.typeID, generator.weight, generator.length, generator.width, generator.height));
        }
        return this.webClient.post().uri("/statue/saveStatues")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(statues), Statue.class).retrieve()
                .bodyToMono(Statue.class);
    }

    public Mono<Statue> saveStatues(Integer size) {
        List<Statue> statues = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Generator generator = new Generator();
            statues.add(new Statue(generator.socha, generator.typeID, generator.weight, generator.length, generator.width, generator.height));
        }
        return this.webClient.post().uri("/statue/saveStatues")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(statues), Statue.class).retrieve()
                .bodyToMono(Statue.class);
    }

}
