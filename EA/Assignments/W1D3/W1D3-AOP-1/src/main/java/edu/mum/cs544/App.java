package edu.mum.cs544;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
	public static void main(String[] args) {
		// ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		// ICustomerService customerService = context.getBean("customerService", ICustomerService.class);

		// customerService.addCustomer("Frank Brown", "fbrown@acme.com",
		// 		"mainstreet 5", "Chicago", "60613");
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("testing spring startup ");
		ClassA a = context.getBean(ClassA.class);

		a.showText();

		context.close();
	}
}
