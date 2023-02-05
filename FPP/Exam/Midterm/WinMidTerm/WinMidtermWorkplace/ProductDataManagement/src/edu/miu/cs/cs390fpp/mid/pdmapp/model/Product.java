package edu.miu.cs.cs390fpp.mid.pdmapp.model;

import java.time.LocalDate;

public class Product implements Comparable<Product>{
	private String productId;
	private long binNumber;
	private String description;
	private double unitPrice;
	private int quantityInStock;
	private LocalDate dateSupplies;
	
	//three constructors including default constructor
	//default
	public Product() {
		super();
	}
	public Product(String productId, long binNumber, String description, double unitPrice, int quantityInStock,
			LocalDate dateSupplies) {
		super();
		this.productId = productId;
		this.binNumber = binNumber;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplies = dateSupplies;
	}
	public Product(String productId, long binNumber, double unitPrice, int quantityInStock, LocalDate dateSupplies) {
		super();
		this.productId = productId;
		this.binNumber = binNumber;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplies = dateSupplies;
	}
	
	//getter and setter for productId
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	//getter and setter for binNumber
	public long getBinNumber() {
		return binNumber;
	}
	public void setBinNumber(long binNumber) {
		this.binNumber = binNumber;
	}
	//getter and setter for description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//getter and setter for unitPrice
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	////getter and setter for quantityInStock
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	//getter and setter for dateSupplied
	public LocalDate getDateSupplies() {
		return dateSupplies;
	}
	public void setDateSupplies(LocalDate dateSupplies) {
		this.dateSupplies = dateSupplies;
	}
	//overriding toString method
	@Override
	public String toString() {
		return String.format("{ ProductId: %s, Bin No: %d, Desc: %s, "
				+ "Price : $%,.2f, QuantityInStock: %d, DateSupplied: %s }", 
				productId,
				binNumber,
				description,
				unitPrice,
				quantityInStock,
				dateSupplies.toString());
	}
	@Override
	public int compareTo(Product o) {
		/*Double originalPrice=Double.valueOf(this.unitPrice);
		Double comparedPrice=Double.valueOf(o.unitPrice);
		return (-1)*originalPrice.compareTo(comparedPrice);*/
		
		if(this.unitPrice > o.unitPrice) return -1;
		else if(this.unitPrice < o.unitPrice) return 1;
		//if equal
		return 0; 
	}
	
}