package lesson4.labs.polymorphism;

import java.util.Date;

public class Order {
	private int orderNo;
	private Date orderDate;
	private double orderAmount;
	

	public Order(int orderNo,Date orderDate,double orderAmount) {
		this.setOrderNo(orderNo);
		this.orderDate=orderDate;
		this.orderAmount=orderAmount;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

}
