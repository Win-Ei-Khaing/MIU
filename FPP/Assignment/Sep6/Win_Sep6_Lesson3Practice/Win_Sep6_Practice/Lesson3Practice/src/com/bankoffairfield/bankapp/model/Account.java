package com.bankoffairfield.bankapp.model;

public final class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private String accountNumber;
	private double balance;
	private AccountType accountType;
	
	public Account(String accountNumber, double balance, AccountType accountType) {
		this.accountNumber=accountNumber;
		this.balance=balance;
		this.accountType=accountType;
	}
	
	public Account(String accountNumber, AccountType accountType) {
		this.accountNumber=accountNumber;
		this.balance=DEFAULT_BALANCE;
		this.accountType=accountType;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
}
