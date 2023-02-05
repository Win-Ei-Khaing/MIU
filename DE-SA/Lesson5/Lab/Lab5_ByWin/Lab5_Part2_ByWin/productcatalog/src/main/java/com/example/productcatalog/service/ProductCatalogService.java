package com.example.productcatalog.service;

import com.example.productcatalog.dao.ProductDAO;
import com.example.productcatalog.domain.Product;
import com.example.productcatalog.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogService {
    @Autowired
    ProductDAO productDAO;

    ProductCatalogAdapter productCatalogAdapter;

    public void addProduct(ProductDTO productDto) {
        productDAO.save(productCatalogAdapter.getProduct(productDto));
    }

    public ProductDTO getProduct(int productnumber) {
        var result=productDAO.findByProductNumber(productnumber);
        return result  == null ? null : productCatalogAdapter.getProductDTO(result);
    }
}
