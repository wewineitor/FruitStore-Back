package com.wewin.fruitStore.fruit.service.impl;

import com.wewin.fruitStore.fruit.dto.FruitDTO;
import com.wewin.fruitStore.fruit.entity.Fruit;
import com.wewin.fruitStore.fruit.repository.FruitRepository;
import com.wewin.fruitStore.fruit.service.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FruitDTO> getAllFruits() {
        List<Fruit> fruits = fruitRepository.findAll();
        return fruits.stream()
                .map(fruit -> modelMapper.map(fruit, FruitDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addFruit(FruitDTO fruitDTO) {
        Fruit fruit = modelMapper.map(fruitDTO, Fruit.class);
        fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }
}
