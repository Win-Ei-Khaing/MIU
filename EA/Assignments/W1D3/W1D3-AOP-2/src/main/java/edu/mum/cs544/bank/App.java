package edu.mum.cs544.bank;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.AccountEntry;
import edu.mum.cs544.bank.domain.Customer;
import edu.mum.cs544.bank.service.IAccountService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("testing spring startup ");
		AClass a = context.getBean(AClass.class);

		a.getAText();;

		a.getBText();

		
	}

}


