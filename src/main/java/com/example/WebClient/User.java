package com.example.WebClient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

