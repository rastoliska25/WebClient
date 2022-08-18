package com.example.WebClient;

import java.util.Random;

public class Generator {
    public Statue createStatue() {
        return new Statue("socha " + new Random().nextInt(1, 100), new Random().nextInt(1, 3), new Random().nextLong(70, 600),
                new Random().nextLong(70, 800), new Random().nextLong(70, 600), new Random().nextLong(400, 2300));
    }
}
