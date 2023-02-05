package com.example.shopping.dao;

import com.example.shopping.domain.Shoppingcart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingDAO extends MongoRepository<Shoppingcart, Integer> {
    public Shoppingcart findByShoppingcardNumber(int shoppingcardNumber);
}
