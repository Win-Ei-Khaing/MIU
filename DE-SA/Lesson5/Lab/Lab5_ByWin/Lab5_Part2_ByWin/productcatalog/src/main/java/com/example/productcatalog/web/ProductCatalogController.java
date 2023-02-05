package com.example.productcatalog.web;

import com.example.productcatalog.domain.Product;
import com.example.productcatalog.dto.ProductDTO;
import com.example.productcatalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductCatalogController {
    @Autowired
    ProductCatalogService productCatalogService;

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        productCatalogService.addProduct(productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/products/{productnumber}")
    public ResponseEntity<?> getProduct(@PathVariable int productnumber) {
        ProductDTO result = productCatalogService.getProduct(productnumber);
        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductDTO>(result, HttpStatus.OK);
    }
}
