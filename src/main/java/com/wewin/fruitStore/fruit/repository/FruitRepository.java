package com.wewin.fruitStore.fruit.repository;

import com.wewin.fruitStore.fruit.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
