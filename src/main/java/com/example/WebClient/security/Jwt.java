package com.example.WebClient.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Jwt {

    private String jwt;

    //@JsonProperty("jwt")
    public Jwt() {
    }

    public Jwt(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    @Override
    public String toString() {
        return "Jwt{" +
                "jwt='" + jwt + '\'' +
                '}';
    }
}
