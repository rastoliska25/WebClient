package com.example.WebClient;


import lombok.Data;

@Data
public class Statue {
    private Integer id;

    private String name;

    private Integer typeId;

    private Long weight;

    private Long length;

    private Long width;

    private Long height;

    public Statue(String name, Integer typeId, Long weight, Long length, Long width, Long height) {
        this.name = name;
        this.typeId = typeId;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Statue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", weight=" + weight +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
