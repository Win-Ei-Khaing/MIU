package prog4_3.employeeinfo;

public class RetirementAccount extends Account {

	private final double PENALTYRATE=2.0/100;
	
	public RetirementAccount(Employee emp, double balance) {
		super(emp, balance);
	}

	public RetirementAccount(Employee emp) {
		super(emp);
	}

	public AccountType getAcctType() {
        return AccountType.RETIREMENT;
	}
	
	public boolean makeWithdrawal(double amount) {
		double existingAmt=super.getBalance();
		double penalty=PENALTYRATE*existingAmt;
		//System.out.println(existingAmt + ", rate: "+PENALTYRATE+", "+penalty + "="+(existingAmt+penalty));
		if((amount+penalty) <= existingAmt) {
			super.makeWithdrawal(amount+penalty);
			return true;
		}
		return false;
	}
}
