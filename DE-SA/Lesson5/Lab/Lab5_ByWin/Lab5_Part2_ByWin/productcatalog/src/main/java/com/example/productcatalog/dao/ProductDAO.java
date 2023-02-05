package com.example.productcatalog.dao;

import com.example.productcatalog.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends MongoRepository<Product, Integer> {
    public Product findByProductNumber(int productNumber);
}
