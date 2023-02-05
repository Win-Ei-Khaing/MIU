package prog3_2.employeeinfo;

import java.time.LocalDate;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
/* update, using LocalDate
		GregorianCalendar cal = new GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire);
		hireDate = cal.getTime();
*/
	}

	
	public void createNewChecking(double startAmount) {
		// implemented by win
		checkingAcct=new Account(this, AccountType.CHECKING, startAmount);
	}

	public void createNewSavings(double startAmount) {
		// implemented by win
		savingsAcct=new Account(this, AccountType.SAVINGS, startAmount);
	}

	public void createNewRetirement(double startAmount) {
		// implemented by win
		retirementAcct=new Account(this, AccountType.RETIREMENT, startAmount);
	}

	public String getFormattedAcctInfo() {
		// implemented by win
		String result="\nACCOUNT INFO FOR "+getName()+":\n\n";
		if(checkingAcct != null)
			result += checkingAcct.toString();
		if(savingsAcct != null)
			result += savingsAcct.toString();
		if(retirementAcct != null)
			result += retirementAcct.toString();
		return result;
	}
	public void deposit(String acctType, double amt){
		// implemented by win
		if(acctType.equalsIgnoreCase(AccountType.CHECKING.toString()))
			checkingAcct.makeDeposit(amt);
		
		if(acctType.equalsIgnoreCase(AccountType.SAVINGS.toString()))
			savingsAcct.makeDeposit(amt);
		
		if(acctType.equalsIgnoreCase(AccountType.RETIREMENT.toString()))
			retirementAcct.makeDeposit(amt);
	}
	public boolean withdraw(String acctType, double amt){
		// implemented by win
		if(acctType.equalsIgnoreCase(AccountType.CHECKING.toString()))
			return checkingAcct.makeWithdrawal(amt);
		
		if(acctType.equalsIgnoreCase(AccountType.SAVINGS.toString()))
			return savingsAcct.makeWithdrawal(amt);
		
		if(acctType.equalsIgnoreCase(AccountType.RETIREMENT.toString()))
			return retirementAcct.makeWithdrawal(amt);
		
		//if acctType is not from enum list, can't withdraw. so return false
		return false; 
	}

	public String getName() {
		return name;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}
}
