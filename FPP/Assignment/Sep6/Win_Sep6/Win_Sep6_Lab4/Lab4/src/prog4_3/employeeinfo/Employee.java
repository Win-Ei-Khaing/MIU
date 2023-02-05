package prog4_3.employeeinfo;

import java.time.LocalDate;

import prog4_3.MyStringList;

public class Employee {

	private AccountList accounts=new AccountList();
	private String name;
	@SuppressWarnings("unused")
	private LocalDate hireDate;

	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	public void createNewChecking(double startAmount) {
		Account acct=new CheckingAccount(this, startAmount);
		accounts.add(acct);
	}

	public void createNewSavings(double startAmount) {
		Account acct=new SavingsAccount(this, startAmount);
		accounts.add(acct);
	}

	public void createNewRetirement(double startAmount) {
		Account acct=new RetirementAccount(this, startAmount);
		accounts.add(acct);
	}

	public String getFormattedAcctInfo() {
		String newline = System.getProperty("line.separator");
		String theString = "ACCOUNT INFO FOR "+name+newline+newline;
		for(int i=0;i<accounts.size();i++) {
			Account acc=accounts.get(i);
			if(acc != null) {
				theString += acc.toString()+newline;
			}
		}
		/*if(checkingAcct != null) theString += checkingAcct.toString()+newline;
		if(savingsAcct != null) theString += savingsAcct.toString()+ newline;
		if(retirementAcct != null) theString += retirementAcct.toString()+ newline;*/
		return theString;
	}

	public void deposit(int accountIndex, double amt) {
		if(accountIndex<0 && accountIndex>=accounts.size())
			return;
		Account selected=accounts.get(accountIndex);
		selected.makeDeposit(amt);

	}

	public boolean withdraw(int accountIndex, double amt){
		if(accountIndex<0 && accountIndex>=accounts.size())
			return false;
		Account selected=accounts.get(accountIndex);
		return selected.makeWithdrawal(amt);
	}
	
	public String getName() {
		return name;
	}
	
	public MyStringList getNamesOfAccounts() {
		MyStringList accNames=new MyStringList();
		for(int i=0;i<accounts.size();i++) {
			Account acc=accounts.get(i);
			if(acc != null) {
				accNames.add(acc.getAcctType().toString().toLowerCase());
			}
		}
		return accNames;
	}
}

