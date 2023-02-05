package prog3_1_startup;

class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	private Employee employee;

	Account(Employee emp, AccountType acctType, double balance) {
		employee = emp;
		this.acctType = acctType;
		this.balance = balance;
	}

	Account(Employee emp, AccountType acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}

	public String toString() {
		return "type = " + acctType + ", balance = " + balance;
	}

	public void makeDeposit(double deposit) {
		// implemented by win
		balance+=deposit;
	}

	public boolean makeWithdrawal(double amount) {
		// implemented by win
		if(amount > balance)
			return false;
		else {
			balance-=amount;
			return true;
		}
	}

	public AccountType getAccType() {
		return acctType;
	}
	
	public double getBalance() {
		return balance;
	}
}
