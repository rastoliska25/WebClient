package com.example.WebClient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private String name;
    private String role;

    public User(Builder builder) {
        setName(builder.name);
        setRole(builder.role);
    }

    public static Builder novyUser(){
        return new Builder();
    }

    public User(){}

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public static class Builder{
        private String name;
        private String role;
        private Builder(){
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder role(String role){
            this.role = role;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

