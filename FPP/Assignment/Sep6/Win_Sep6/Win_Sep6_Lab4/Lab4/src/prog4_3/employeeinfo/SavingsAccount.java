package prog4_3.employeeinfo;

public class SavingsAccount extends Account {
	private final double INSTESTRATE=0.25/100;
	
	public SavingsAccount(Employee emp, double balance) {
		super(emp, balance);
	}

	public SavingsAccount(Employee emp) {
		super(emp);
	}

	public AccountType getAcctType() {
		return AccountType.SAVINGS;
	}

	public double getBalance() {
		double baseBalance = super.getBalance();
		double interest = INSTESTRATE*baseBalance;
		return baseBalance + interest;
	}
}
