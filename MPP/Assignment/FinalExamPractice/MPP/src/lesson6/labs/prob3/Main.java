package lesson6.labs.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
	private static final String NAME = "name";
	private static final String STREET = "street";
	private static final String CITY = "city";
	private static final String ZIP = "zip";

	// Use the DomServiceClass to get all customers
	// whose city of residence begins with "Ma", in sorted order.
	// Create
	public List<Customer> allCustomersBeginWithMa() throws DomException {
		List<Customer> customers = new ArrayList<Customer>();

		DomServiceClass domServiceClass = new DomServiceClass(
				"src\\lesson6\\labs\\prob3\\customer.xml");
		List<Properties> properties = domServiceClass.lookupEntry("city", "Ma");

		for (Properties customerProperties : properties) {
			customers.add(new Customer(customerProperties.getProperty("name"),
					customerProperties.getProperty("street"),
					customerProperties.getProperty("city"), customerProperties
							.getProperty("zip")));
		}

		return customers;
	}

	public static void main(String[] args) throws DomException {
		Main m = new Main();
		List<Customer> list = m.allCustomersBeginWithMa();
		System.out.println(list);

	}

}
