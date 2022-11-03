package partc;

import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee{
	private double commission;
	private double baseSalary;
	private List<Order> orders;

	public Commissioned(int empId, double commission, double baseSalary) {
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
		orders = new ArrayList<Order>();
	}
	public double getCommission() {
		return commission;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public double calcGrossPay(int month, int yr) {
		/*
	//if commission is for previous month's orders, we have to go back previous month
	if(month < 1 || month > 12) return 0; //checking month valid or not

	int previousMonth, previousYear;
	if(month == 1) {
		previousMonth = 12;
		previousYear = yr-1;
	}
	else {
		previousMonth = month - 1;
		previousYear = yr;
	}
		 */

		for(Order o : orders) {
			if((o.getOrderDate().getMonthValue() == month) && (o.getOrderDate().getYear() == yr))
				commission += o.getOrderAmount();
		}
		return baseSalary + commission;
	}

	/*public static void main(String[] args) {
		Commissioned c = new Commissioned(1, 0, 1000);
		LocalDate date1 = LocalDate.of(2020, 1, 8);
		Order o1 = new Order(1, date1, 100);
		Order o2 = new Order(2, date1, 200);
		LocalDate date2 = LocalDate.of(2021, 1, 8);
		Order o3 = new Order(3, date2, 300);
		c.addOrder(o1);
		c.addOrder(o2);
		c.addOrder(o3);

		System.out.println(c.calcGrossPay(1, 2020));
	}*/
}
