package prob3.extpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import prob3.CustOrder;
import prob3.CustOrderFactory;

public class Main {
	public static void main(String[] args) {
		CustOrder cust = CustOrderFactory.createCustomer("Bob");
		List<String> itemList1 = new ArrayList<String>();
		itemList1.add("Shirt");
		itemList1.add("Laptop");
		CustOrderFactory.newOrder(cust.getCustomer(), LocalDate.now(), itemList1);

		List<String> itemList2 = new ArrayList<String>();
		itemList2.add("Pants");
		itemList2.add("Knife set");
		CustOrderFactory.newOrder(cust.getCustomer(), LocalDate.now(), itemList2);

		System.out.println(cust.getCustomer().getOrders());
	}
}


