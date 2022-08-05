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

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU5NzE4OTQ4LCJpYXQiOjE2NTk2ODI5NDh9.H58mAW6Hj9wEeZe0OfxTK3CEW5A1_wD3T7Mt0dO5dzU";
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
        User user = new User(100, "Ferko2", "testovac2");
        return this.webClient.post().uri("/user")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(user), User.class).retrieve()
                .bodyToMono(User.class);
    }




    //original
    /*
    public Mono<Statue> saveStatue() {
        Generator generator = new Generator();
        //for(int pocet = 0; pocet<20; pocet++){
        Statue statue = new Statue(generator.socha, 1, generator.weight, generator.length, generator.width, generator.height);
        return this.webClient.post().uri("/statue")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU5NjM2NDAwLCJpYXQiOjE2NTk2MDA0MDB9.vdafL-RsYUyKc5ws0KOx07sm7O9kyFvCAj6coFUovW8"))
                .body(Mono.just(statue), Statue.class).retrieve()
                .bodyToMono(Statue.class);
    }
    */


    public Mono<Statue> saveStatue() {
        Generator generator = new Generator();
        //for(int pocet = 0; pocet<20; pocet++) {
            Statue statue = new Statue(generator.socha, 1, generator.weight, generator.length, generator.width, generator.height);
            this.webClient.post().uri("/statue")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .headers(h -> h.setBearerAuth(token))
                    .body(Mono.just(statue), Statue.class).retrieve()
                    .bodyToMono(Statue.class);
        return this.webClient.post().uri("/statue")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(statue), Statue.class).retrieve()
                .bodyToMono(Statue.class);
    }


    public Mono<Statue> saveStatueFlux() {

        List<Statue> statues = new ArrayList<>();
        statues.add(new Statue("socha1", 1, new Random().nextLong(100,130), new Random().nextLong(100,130), new Random().nextLong(100,130), new Random().nextLong(100,130)));
        statues.add(new Statue("socha2", 1, new Random().nextLong(200,1300), new Random().nextLong(200,1300), new Random().nextLong(200,1300), new Random().nextLong(200,1300)));
        return this.webClient.post().uri("/statue")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU5NjM2NDAwLCJpYXQiOjE2NTk2MDA0MDB9.vdafL-RsYUyKc5ws0KOx07sm7O9kyFvCAj6coFUovW8"))
                .body(Flux.just(statues), Statue.class).retrieve()
                .bodyToMono(Statue.class);

    }


    //test
    /*
    public Mono<Statue> saveStatue() {
        Generator generator = new Generator();
        List<Statue> statueList = new ArrayList<>();
        for (int i = 0; i<20; i++) {
            statueList.add(new Statue(generator.socha, 1, generator.weight, generator.length, generator.width, generator.height));
        }
/*
        for (Statue statue : statueList) {
            return this.webClient.post().uri("/statue")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .headers(h -> h.setBearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU5NjM2NDAwLCJpYXQiOjE2NTk2MDA0MDB9.vdafL-RsYUyKc5ws0KOx07sm7O9kyFvCAj6coFUovW8"))
                    .body(Mono.just(statue), Statue.class).retrieve()
                    .bodyToMono(Statue.class);
        }
        return this.webClient.post().uri("/statue")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU5NjM2NDAwLCJpYXQiOjE2NTk2MDA0MDB9.vdafL-RsYUyKc5ws0KOx07sm7O9kyFvCAj6coFUovW8"))
                .body(Mono.just(statueList), Statue.class).retrieve()
                .bodyToMono(Statue.class);
    }*/

}
