package com.example.shopping.dto;

public class CartLineDTO {
    private int quantity;
    private int productNumber;

    public CartLineDTO() {
    }

    public CartLineDTO(int quantity, int productNumber) {
        this.quantity = quantity;
        this.productNumber = productNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }
}
