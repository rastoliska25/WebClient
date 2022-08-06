package com.example.WebClient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

   // @Id
   // @GeneratedValue
    private Integer id;
    private String name;
    private String role;

    public User(){}

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @JsonCreator
    public User(@JsonProperty("id") Integer id, String name, String role) {  //musi byť kvôli chybe no int/Int-argument constructor/factory method to deserialize from Number value
        this.name = name;
        this.role = role;
        this.id = id;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

