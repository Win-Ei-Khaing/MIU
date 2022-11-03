package lesson4.labs.polymorphism;

import java.time.LocalDate;

public abstract class Employee {
	private String empId;

	public Employee(String empId) {
		this.empId = empId;
	}

	public void print() {
		System.out.println("Employee: " + this.empId);

		PayCheck check = calcCompensation(LocalDate.now().getMonthValue(),
				LocalDate.now().getYear());
		if (check != null) {
			check.print();
		}
		System.out.println();
	}

	public PayCheck calcCompensation(int month, int year) {
		double grossPay = calcGrossPay(month, year);
		double netPay = grossPay - (grossPay * Tax.fica.getValue())
				- (grossPay * Tax.state.getValue())
				- (grossPay * Tax.local.getValue())
				- (grossPay * Tax.medicare.getValue())
				- (grossPay * Tax.socialSecurity.getValue());

		PayCheck check = new PayCheck(grossPay, netPay);
		return check;
	}

	public abstract double calcGrossPay(int month, int year);

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
