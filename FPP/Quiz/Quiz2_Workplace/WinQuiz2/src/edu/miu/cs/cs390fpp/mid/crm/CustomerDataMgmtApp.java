package edu.miu.cs.cs390fpp.mid.crm;

import java.time.LocalDate;
import java.util.Arrays;

import edu.miu.cs.cs390fpp.mid.crm.model.Customer;

public class CustomerDataMgmtApp {
	public static void main(String[] args) {
		Customer[] customerAry=new Customer[2];
		LocalDate dob1=LocalDate.of(1921,3,11);
		Customer cus1=new Customer(9123456780L,"Bob Jones", 11650.50, dob1);
		customerAry[0]=cus1;
		
		LocalDate dob2=LocalDate.of(1978,12,29);
		Customer cus2=new Customer(9123456789L,"Anna Smith", 40900.00, dob2);
		customerAry[1]=cus2;
		
		printCustomers(customerAry);
		sortCustomers(customerAry);
	}
	
	public static void printCustomers(Customer[] cusAry) {
		String displayText="";
		for(Customer cus : cusAry) {
			displayText+=cus.toString()+"\n";
		}
		System.out.println(displayText);
	}
	
	private static void sortCustomers(Customer[] cusAry) {
		Arrays.sort(cusAry);
		System.out.println("After sorting : ");
		printCustomers(cusAry);
	}
}
