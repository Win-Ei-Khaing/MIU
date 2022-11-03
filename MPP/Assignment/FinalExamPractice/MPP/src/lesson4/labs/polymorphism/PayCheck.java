package lesson4.labs.polymorphism;

public class PayCheck {
	private double grossPay;
	private double netPay;

	public PayCheck(double grossPay, double netPay) {
		this.grossPay = grossPay;
		this.netPay = netPay;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public double getNetPay() {
		return netPay;
	}

	public void print() {
		System.out.println("Paycheck:");
		System.out.println("Gross Pay is " + this.grossPay);
		System.out.println("Net Pay is " + this.netPay);
	}
}
