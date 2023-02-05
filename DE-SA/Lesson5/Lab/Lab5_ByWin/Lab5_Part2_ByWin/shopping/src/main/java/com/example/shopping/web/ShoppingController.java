package com.example.shopping.web;

import com.example.shopping.domain.Shoppingcart;
import com.example.shopping.dto.ShoppingcartDTO;
import com.example.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingController {
    @Autowired
    ShoppingService shoppingService;

    @PostMapping("/shoppingcarts")
    public ResponseEntity<?> addToShoppingCart(@RequestBody ShoppingcartDTO shoppingcartDTO) {
        shoppingService.addToShoppingCart(shoppingcartDTO);
        return new ResponseEntity<ShoppingcartDTO>(shoppingcartDTO, HttpStatus.OK);
    }

    @GetMapping("/shoppingcarts/{shoppingcartNumber}")
    public ResponseEntity<?> getShoppingCart(@PathVariable int shoppingcartNumber) {
        var result = shoppingService.getShoppingCart(shoppingcartNumber);
        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ShoppingcartDTO>(result, HttpStatus.OK);
    }
}
