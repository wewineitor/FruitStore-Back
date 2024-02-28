package com.wewin.fruitStore.fruit.service;

import com.wewin.fruitStore.fruit.dto.FruitDTO;

import java.util.List;

public interface FruitService {
    List<FruitDTO> getAllFruits();
    void addFruit(FruitDTO fruitDTO);
    void deleteFruit(Long id);
}