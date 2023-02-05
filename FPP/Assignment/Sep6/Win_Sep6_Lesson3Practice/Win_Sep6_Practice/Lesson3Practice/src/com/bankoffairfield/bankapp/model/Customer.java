package com.bankoffairfield.bankapp.model;

import java.time.LocalDate;

public final class Customer {
	private final long customerId;
	private final String name;
	private final LocalDate dateOfBirth;
	private final Account account;
	
	public Customer(long customerId, String name, int year, int month, int day, Account account) {
		this.customerId=customerId;
		this.name=name;
		this.dateOfBirth=LocalDate.of(year, month, day);
		this.account=account;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public Account getAccount() {
		return account;
	}
}
