package com.example.WebClient;

import java.util.Random;

public class Generator {
    Random rand = new Random();
    Long weight = new Random().nextLong(100,1300);
    Long length = new Random().nextLong(250,1400);
    Long width = new Random().nextLong(250,700);
    Long height = new Random().nextLong(400,2300);
}
