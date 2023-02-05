package com.example.productcatalog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Product {
    @Id
    private int productNumber;
    private String description;
    private double price;
    private int supplierNumber;
    private Stock stock;
    private List<Review> reviews;

    public Product() {
    }

    public Product(int productNumber, String description, double price, int supplierNumber) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.supplierNumber = supplierNumber;
    }

    public Product(int productNumber, String description, double price, int supplierNumber, Stock stock, List<Review> reviews) {
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
