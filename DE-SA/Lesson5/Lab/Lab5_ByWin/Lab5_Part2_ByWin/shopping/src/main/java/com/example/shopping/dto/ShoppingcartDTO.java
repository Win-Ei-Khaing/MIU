package com.example.shopping.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ShoppingcartDTO {
    private int shoppingcardNumber;
    private List<CartLineDTO> cartLineDTOs;

    public ShoppingcartDTO() {
    }

    public ShoppingcartDTO(int shoppingcardNumber, List<CartLineDTO> cartLines) {
        this.shoppingcardNumber = shoppingcardNumber;
        this.cartLineDTOs = cartLines;
    }

    public int getShoppingcardNumber() {
        return shoppingcardNumber;
    }

    public void setShoppingcardNumber(int shoppingcardNumber) {
        this.shoppingcardNumber = shoppingcardNumber;
    }

    public List<CartLineDTO> getCartLineDTOs() {
        return cartLineDTOs;
    }

    public void setCartLines(List<CartLineDTO> cartLines) {
        this.cartLineDTOs = cartLines;
    }
}
