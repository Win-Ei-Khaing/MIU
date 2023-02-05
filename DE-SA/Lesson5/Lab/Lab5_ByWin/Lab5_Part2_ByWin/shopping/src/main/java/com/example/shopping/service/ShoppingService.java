package com.example.shopping.service;

import com.example.shopping.dao.ShoppingDAO;
import com.example.shopping.dto.ShoppingcartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {
    @Autowired
    ShoppingDAO shoppingDAO;

    ShoppingAdapter shoppingAdapter;

    public void addToShoppingCart(ShoppingcartDTO shoppingcartDTO) {
        shoppingDAO.save(shoppingAdapter.getShoppingcart(shoppingcartDTO));
    }

    public ShoppingcartDTO getShoppingCart(int shoppingcartNumber) {
        var result=shoppingDAO.findByShoppingcardNumber(shoppingcartNumber);
        return result  == null ? null : shoppingAdapter.getShoppingcartDTO(result);
    }
}
