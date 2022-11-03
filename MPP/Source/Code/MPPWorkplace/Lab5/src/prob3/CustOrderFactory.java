package prob3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final public class CustOrderFactory {
	private CustOrderFactory(){}

	public static  CustOrder createCustomer(String name) {
		Customer c = new Customer(name);
		return new CustOrderImpl(c, null);
	}

	public static CustOrder newOrder(Customer c, LocalDate orderDate, List<String> itemStringList) {
		Order o = new Order(orderDate);
		List<Item> items = new ArrayList<Item>();
		for(String i : itemStringList) {
			o.addItem(i);

			Item item = new Item(i);
			items.add(item);
		}
		c.addOrder(o);
		return new CustOrderImpl(c, o);
	}
}
