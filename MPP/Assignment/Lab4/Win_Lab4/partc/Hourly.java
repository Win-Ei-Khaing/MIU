package partc;

public class Hourly extends Employee{
	private double hourlyWage;
	private float hoursPerWeek;
	public Hourly(int empId, double hourlyWage, float hoursPerWeek) {
		super(empId);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public float getHoursPerWeek() {
		return hoursPerWeek;
	}
	@Override
	public double calcGrossPay(int month, int yr) {
		//If month and yr are number of months and years.
		//So I should mulitply with them in gross pay calculation.
		//double grossPay = hourlyWage * hoursPerWeek * 4 * month * yr;
		
		//this time, I will think month and year is 
		//to calculate gross pay in that month of that year
		double grossPay = hourlyWage * hoursPerWeek * 4;
		return grossPay;
	}
}
