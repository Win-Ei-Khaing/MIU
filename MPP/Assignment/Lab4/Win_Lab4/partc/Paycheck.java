package partc;

public final class Paycheck {
	private final double grossPay;
	private final double fica;
	private final double state;
	private final double local;
	private final double medicare;
	private final double socialSecurity;

	public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
		this.grossPay = grossPay;
		this.fica = fica;
		this.state = state;
		this.local = local;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
	}
	
	public double getGrossPay() {
		return grossPay;
	}
	public double getFica() {
		return fica;
	}
	public double getState() {
		return state;
	}
	public double getLocal() {
		return local;
	}
	public double getMedicare() {
		return medicare;
	}
	public double getSocialSecurity() {
		return socialSecurity;
	}
	
	public void print() {
		System.out.printf("gross pay : %.2f \nfica : %.2f \nstate : %.2f \n"
				+ "local : %.2f \nmedicare : %.2f \nsocial security : %.2f \n", 
				grossPay, fica, state, local, medicare, socialSecurity);
	}
	
	public double getNetPay() {
		return grossPay - (fica + state + local + medicare + socialSecurity);
	}
	
	/*public static void main(String[] args) {
		Paycheck pc=new Paycheck(100);
		pc.print();
		
		System.out.println("Net pay : " + pc.getNetPay());
	}*/
}
