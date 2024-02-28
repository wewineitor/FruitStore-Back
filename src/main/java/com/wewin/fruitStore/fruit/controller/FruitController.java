package com.wewin.fruitStore.fruit.controller;

import com.wewin.fruitStore.fruit.dto.FruitDTO;
import com.wewin.fruitStore.fruit.service.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@AllArgsConstructor
public class FruitController {
    private final FruitService fruitService;

    @GetMapping
    public ResponseEntity<List<FruitDTO>> getAllFruits() {
        return ResponseEntity.ok(fruitService.getAllFruits());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addAudit(@RequestBody FruitDTO fruitDTO) {
        fruitService.addFruit(fruitDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        fruitService.deleteFruit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
