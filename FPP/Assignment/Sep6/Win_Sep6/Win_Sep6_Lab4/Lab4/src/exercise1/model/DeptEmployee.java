package exercise1.model;

import java.time.LocalDate;

public class DeptEmployee{
	private String name;
	private double salary;
	private LocalDate hireDate;
	
	public DeptEmployee(String name, double salary, int year, int month, int day) {
		super();
		this.name = name;
		this.salary=salary;
		LocalDate hireDate=LocalDate.of(year, month, day);
		this.hireDate = hireDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public double computeSalary() {
		return salary;
	}
	
	public String toString() {
		return String.format("Name : %s , Salary : %.2f , Hire Date : %s ", name, salary, hireDate.toString());
	}
}
