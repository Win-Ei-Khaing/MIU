package com.bankoffairfield.bankapp;

import java.text.DecimalFormat;

import com.bankoffairfield.bankapp.model.Account;
import com.bankoffairfield.bankapp.model.AccountType;
import com.bankoffairfield.bankapp.model.Customer;

public class BankApp {

	public static void main(String[] args) {
		
		Account account1 = new Account("101-C-001", 1650.95, AccountType.Checking);
		Account account2 = new Account("102-S-002", 1500.00, AccountType.Savings);
		Account account3 = new Account("102-L-001", 100650.50, AccountType.Loan);

		Customer[] customerAry=new Customer[3];
		customerAry[0] = new Customer(9123456780L, "Anna Lynn Smith", 1957, 03, 18, account1);
		customerAry[1] = new Customer(9123456782L, "Bob R. Jones", 2001, 04, 30, account2);
		customerAry[2] = new Customer(9123456782L, "Carlos Hernandez", 1991, 10, 24, account3);
		
		printCustomers(customerAry);
	}
	
	public static void printCustomers(Customer[] customerAry) {
		for(Customer customer : customerAry) {
			//we can simple use %.2f. but this is because I want to put comma
			DecimalFormat formatter = new DecimalFormat("#,###.00");  
			String result=String.format("{CuotomerId: %d, "
					+ "Name: %s, "
					+ "DoB: %s, "
					+ "AccountNumber: %s, "
					+ "Balance: $%s, "
					+ "AccountType: %s}", 
					customer.getCustomerId(),
					customer.getName(),
					customer.getDateOfBirth().toString().replace('-', '/'),
					customer.getAccount().getAccountNumber(),
					formatter.format(customer.getAccount().getBalance()),
					customer.getAccount().getAccountType().toString());
			System.out.println(result);
		}
	}
}
