package com.example.WebClient;

import lombok.Data;

@Data
public class User {
    private String name;
    private String role;

    public User(){}

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
