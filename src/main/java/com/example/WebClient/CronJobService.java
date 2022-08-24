package com.example.WebClient;

import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CronJobService {

    @SneakyThrows
    @Scheduled(cron = "0/15 * * * * ?") //(fixedRate = 15000)
    @Async
    public void startBatch() {
        System.out.println("actual time: " + new Date());
    }
}
