package com.example.WebClient;

import java.util.Random;

public class UserGenerator {
    public static User createUser() {
        return new User("user " + new Random().nextInt(1, 100), "rola " + new Random().nextInt(1, 100));
    }
}
