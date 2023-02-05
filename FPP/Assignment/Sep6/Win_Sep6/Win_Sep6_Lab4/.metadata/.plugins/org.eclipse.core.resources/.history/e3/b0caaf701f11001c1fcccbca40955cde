package prog4_3.employeeinfo;

public class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private Employee employee;

	Account(Employee emp, double balance) {
		employee = emp;
		this.balance = balance;
	}

	Account(Employee emp) {
		this(emp, DEFAULT_BALANCE);
	}

	public String toString() {
		return "Account Type: "+getAcctType().toString().toLowerCase()+", Current Bal: "+getBalance();
	}
	
	public void makeDeposit(double deposit) {
		balance += deposit;
	}
	
	public boolean makeWithdrawal(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public AccountType getAcctType() {
		return null;
	}
}
