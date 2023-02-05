package lab4_7.employeeinfo;

public class CheckingAccount extends Account {
	public CheckingAccount(Employee emp, double balance) {
		super(emp, balance);
	}

	public CheckingAccount(Employee emp) {
		super(emp);
	}

	public AccountType getAcctType() {
		return AccountType.CHECKING;
	}
	
	/*@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		return baseBalance - 5;
	}*/
}
