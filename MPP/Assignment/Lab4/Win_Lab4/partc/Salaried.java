package partc;

public class Salaried extends Employee{
	private double salary;
	public Salaried(int empId, double salary) {
		super(empId);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	@Override
	public double calcGrossPay(int month, int yr) {
		double grossPay = salary;
		return grossPay;
	}
}
