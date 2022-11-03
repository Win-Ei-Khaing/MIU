package lesson4.labs.polymorphism;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Commissioned extends Employee {
	private double commission;
	private double baseSalary;
	private List<Order> orders;

	public Commissioned(String empId,double baseSalary) {
		super(empId);
		orders = new ArrayList<Order>();
		this.baseSalary=baseSalary;
	}

	@Override
	public double calcGrossPay(int month, int year) {
		double grossPay = this.baseSalary + getCommision(month, year);
		return grossPay;
	}

	public double getCommision(int month, int year) {
		Calendar cal = Calendar.getInstance();

		commission = 0;
		for (Order order : this.orders) {
			cal.setTime(order.getOrderDate());
			if (cal.get(Calendar.MONTH) == (month-1)
					&& cal.get(Calendar.YEAR) == year) {
				commission += order.getOrderAmount();
			}
		}
		return commission;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}
}
