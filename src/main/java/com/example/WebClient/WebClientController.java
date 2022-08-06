package com.example.WebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/web")
public class
WebClientController {

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
    public Mono<User> saveUser(){
        return webClientService.saveUser();}

    @GetMapping("/createUsers")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> saveUsers(){
        return webClientService.saveUsers();}

    @GetMapping("/createStatue")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Statue> saveStatue(){
        return webClientService.saveStatue();}

    @GetMapping("/createStatues")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Statue> saveStatues(){
        return webClientService.saveStatues();}

    @GetMapping("/createStatues/{size}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Statue> saveStatues(@PathVariable Integer size){
        return webClientService.saveStatues(size);}
}
