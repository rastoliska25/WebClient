package com.example.WebClient;

import java.util.Random;

public class Generator {
    Random rand = new Random();
    Long weight = new Random().nextLong(400,700);
    Long length = new Random().nextLong(70,800);
    Long width = new Random().nextLong(70,600);
    Long height = new Random().nextLong(400,2300);

    Integer typeID = new Random().nextInt(1,3);

    String socha = "socha " + rand.nextInt(1,100);
}
