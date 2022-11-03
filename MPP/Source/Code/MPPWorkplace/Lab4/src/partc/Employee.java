package partc;

public abstract class Employee {
	private int empId;

	public Employee(int empId) {
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}

	public void print() {
		System.out.println("Employee Id : " + empId);
	}
	
	public Paycheck calcCompensation(int month, int year) {
		double grossPay = calcGrossPay(month, year);
		
		double fica = grossPay * 0.23;
		double state = grossPay * 0.05;
		double local = grossPay * 0.01;
		double medicare = grossPay * 0.03;
		double socialSecurity = grossPay * 0.075;
		
		Paycheck paycheck = new Paycheck(grossPay, fica, state, local, medicare, socialSecurity);
		return paycheck;
	}
	
	public abstract double calcGrossPay(int month, int yr);
	
	public static void main(String[] args) {
		Employee e = new Hourly(1, 10, 25);
		Paycheck p = e.calcCompensation(1, 2021);
		p.print();
		System.out.println(p.getNetPay());
	}
}
