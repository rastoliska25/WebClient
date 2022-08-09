package com.example.WebClient;

import java.util.Random;

public class Generator {
    Random rand = new Random();
    Long weight = new Random().nextLong(100,500);
    Long length = new Random().nextLong(250,800);
    Long width = new Random().nextLong(200,600);
    Long height = new Random().nextLong(400,2300);

    Integer typeID = new Random().nextInt(1,3);

    String socha = "socha " + rand.nextInt(1,100);
}
