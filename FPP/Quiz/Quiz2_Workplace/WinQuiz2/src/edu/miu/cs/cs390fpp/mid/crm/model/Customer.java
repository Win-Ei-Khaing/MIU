package edu.miu.cs.cs390fpp.mid.crm.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Customer implements Comparable<Customer>{
	private long customerId;
	private String name;
	private double salary;
	private LocalDate dateOfBirth;

	public Customer() {
		super();
	}
	public Customer(long customerId, String name, double salary, LocalDate dateOfBirth) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
	}
	public Customer(long customerId, String name, double salary) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.salary = salary;
	}
	public Customer(long customerId, String name) {
		super();
		this.customerId = customerId;
		this.name = name;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String toString() {
		StringJoiner sj=new StringJoiner(",","[","]");
		sj.add("CustomerId: "+customerId);
		sj.add("Name: "+name);
		sj.add("Salary: $"+String.format("%,.2f", salary));
		sj.add("DateofBirth: "+dateOfBirth);

		return sj.toString();
	}
	@Override
	public int compareTo(Customer o) {
		return(name.compareTo(o.getName()));
	}
}
