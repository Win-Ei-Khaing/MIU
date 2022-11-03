package OtherPackage;

import factory.Factory;
import factory.Product;

public class Client {
	public static void main(String[] args) {
		Product p = Factory.getNewConcreteProduct("Win Product");
		System.out.println(p.getProductName());
	}
}
