package com.example.WebClient;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CronJobService {

    @Autowired
    private WebClientService webClientService;

    @SneakyThrows
    @Scheduled(cron = "0/10 * * * * ?") //(fixedRate = 10000)
    @Async
    public void startBatch() {
        System.out.println("actual time: " + new Date());
    }


    @Async
    @Scheduled(fixedRate = 50000000)
    @SneakyThrows
    public void createKeyMessages() {
        webClientService.createKey();
    }

    //test

    @SneakyThrows
    @Scheduled(cron = "0/5 * * * * ?") //(fixedRate = 10000)
    @Async
    public void encryptMessages2() {
        webClientService.encryptMessagesVoid();
    }

}



