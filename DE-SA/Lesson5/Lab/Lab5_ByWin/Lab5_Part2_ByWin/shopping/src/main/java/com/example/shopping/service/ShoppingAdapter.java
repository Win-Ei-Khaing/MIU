package com.example.shopping.service;

import com.example.shopping.domain.CartLine;
import com.example.shopping.domain.Shoppingcart;
import com.example.shopping.dto.CartLineDTO;
import com.example.shopping.dto.ShoppingcartDTO;

import java.util.ArrayList;

public class ShoppingAdapter {
    public static Shoppingcart getShoppingcart(ShoppingcartDTO shoppingcartDTO){
        var cartLines= new ArrayList<CartLine>();
        for (var cartLineDto:shoppingcartDTO.getCartLineDTOs()) {
            cartLines.add(getCartLine(cartLineDto));
        }
        return new Shoppingcart(shoppingcartDTO.getShoppingcardNumber(), cartLines);
    }

    public static CartLine getCartLine(CartLineDTO cartLineDTO){
        return new CartLine(cartLineDTO.getQuantity(), cartLineDTO.getProductNumber());
    }

    public static ShoppingcartDTO getShoppingcartDTO(Shoppingcart shoppingcart){
        var cartLineDTOs= new ArrayList<CartLineDTO>();
        for (var cartLine:shoppingcart.getCartLines()) {
            cartLineDTOs.add(getCartLineDTO(cartLine));
        }
        return new ShoppingcartDTO(shoppingcart.getShoppingcardNumber(), cartLineDTOs);
    }

    public static CartLineDTO getCartLineDTO(CartLine cartLine){
        return new CartLineDTO(cartLine.getQuantity(), cartLine.getProductNumber());
    }
}
