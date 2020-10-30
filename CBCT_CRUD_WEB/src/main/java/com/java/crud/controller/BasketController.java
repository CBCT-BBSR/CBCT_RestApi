package com.java.crud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.crud.model.Basket;
import com.java.crud.repository.BasketRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    BasketRepository basketRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }


    @GetMapping
    public List<Basket> getAllBaskets(){
        return basketRepository.getBasket();
    }

    @GetMapping(value = "/{basket_id}")
    public ResponseEntity<?> getBasket(@PathVariable("basket_id") String basket_id) {
        Basket basket = basketRepository.findById(basket_id);
        if (basket == null) {
            return new ResponseEntity<String>("No User found with this "+ basket_id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Basket>(basket, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBasket(@RequestBody Basket basket) throws SQLIntegrityConstraintViolationException {
        if (basketRepository.findById(basket.getBasket_id()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ basket.getBasket_id(), HttpStatus.IM_USED);
        }
        basketRepository.saveBasket(basket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateBasket(@RequestBody Basket basket) {
        if (basketRepository.findById(basket.getBasket_id()) == null) {
            return new ResponseEntity<String>("Unable to update as  Basket id " + basket.getBasket_id() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        basketRepository.updateBasket(basket);
        return new ResponseEntity<Basket>(basket, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{basket_id}")
    public ResponseEntity<?> deleteBasket(@PathVariable("basket_id") String basket_id) {
    	Basket basket = basketRepository.findById(basket_id);
        if (basket == null) {
            return new ResponseEntity<String>("Unable to delete as Basket Id "+ basket_id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Basket>(basket, HttpStatus.NO_CONTENT);
    }


}
