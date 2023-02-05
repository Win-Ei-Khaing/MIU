package com.example.shopping.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Shoppingcart {
    private int shoppingcardNumber;
    private List<CartLine> cartLines;

    public Shoppingcart() {
    }

    public Shoppingcart(int shoppingcardNumber, List<CartLine> cartLines) {
        this.shoppingcardNumber = shoppingcardNumber;
        this.cartLines = cartLines;
    }

    public int getShoppingcardNumber() {
        return shoppingcardNumber;
    }

    public void setShoppingcardNumber(int shoppingcardNumber) {
        this.shoppingcardNumber = shoppingcardNumber;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }
}
