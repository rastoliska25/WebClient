package com.example.WebClient;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@Data
public class Statue {

    private String name;

    private Integer typeId;

    private Long weight;

    private Long length;

    private Long width;

    private Long height;
}
