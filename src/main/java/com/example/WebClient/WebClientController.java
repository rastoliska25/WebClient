package com.example.WebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/web")
public class WebClientController {

    @Autowired
    WebClientService webClientService;

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<User> getUserById(@PathVariable Long id){
        return webClientService.findUserById(id);
    }

    @GetMapping(value = "/user",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<User> findAllUsers(){
        return webClientService.findUsers();
    }
    //curl http://localhost:8081/web/user

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(){webClientService.saveUser();}

}
