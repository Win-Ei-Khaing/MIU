package com.example.productcatalog.service;

import com.example.productcatalog.domain.Product;
import com.example.productcatalog.domain.Review;
import com.example.productcatalog.domain.Stock;
import com.example.productcatalog.dto.ProductDTO;
import com.example.productcatalog.dto.ReviewDTO;
import com.example.productcatalog.dto.StockDTO;

import java.util.ArrayList;
import java.util.List;


public class ProductCatalogAdapter {

    public static Product getProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getProductNumber(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getSupplierNumber()
        );
    }

    public static ProductDTO getProductDTO(Product product) {
        return new ProductDTO(
                product.getProductNumber(),
                product.getDescription(),
                product.getPrice(),
                product.getSupplierNumber()
        );
    }

    public static Stock getStock(StockDTO stockDTO){
        return new Stock(
                stockDTO.getNrInStock(),
                stockDTO.getLocationCode()
        );
    }

    public static StockDTO getStockDTO(Stock stock){
        return new StockDTO(
                stock.getNrInStock(),
                stock.getLocationCode()
        );
    }

    public static List<Review> getReviews(List<ReviewDTO> reviewDTOList){
        List<Review> result=new ArrayList<Review>();
        for (var reviewDTO: reviewDTOList) {
            result.add(new Review(reviewDTO.getTitle(), reviewDTO.getDescription(), reviewDTO.getScore()));
        }
        return result;
    }

    public static List<ReviewDTO> getReviewDTOs(List<Review> reviewList){
        List<ReviewDTO> result=new ArrayList<ReviewDTO>();
        for (var review: reviewList) {
            result.add(new ReviewDTO(review.getTitle(), review.getDescription(), review.getScore()));
        }
        return result;
    }
}
