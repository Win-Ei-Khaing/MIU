package com.example.restclient.dto;

import java.util.List;

public class ProductDTO {
    private int productNumber;
    private String description;
    private double price;
    private int supplierNumber;
    private StockDTO stock;
    private List<ReviewDTO> reviews;

    public ProductDTO() {
    }

    public ProductDTO(int productNumber, String description, double price, int supplierNumber) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.supplierNumber = supplierNumber;
    }

    public ProductDTO(int productNumber, String description, double price, int supplierNumber, StockDTO stock, List<ReviewDTO> reviews) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.supplierNumber = supplierNumber;
        this.stock = stock;
        this.reviews = reviews;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(int supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public StockDTO getStock() {
        return stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }
}
