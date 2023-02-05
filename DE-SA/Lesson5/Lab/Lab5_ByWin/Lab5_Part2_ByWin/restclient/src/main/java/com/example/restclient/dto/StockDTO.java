package com.example.restclient.dto;

public class StockDTO {
    private int nrInStock;
    private String locationCode;

    public StockDTO() {
    }

    public StockDTO(int nrInStock, String locationCode) {
        this.nrInStock = nrInStock;
        this.locationCode = locationCode;
    }

    public int getNrInStock() {
        return nrInStock;
    }

    public void setNrInStock(int nrInStock) {
        this.nrInStock = nrInStock;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}
