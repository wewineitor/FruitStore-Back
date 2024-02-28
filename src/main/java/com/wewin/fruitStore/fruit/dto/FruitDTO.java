package com.wewin.fruitStore.fruit.dto;

import lombok.Data;

@Data
public class FruitDTO {
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private String image;
}