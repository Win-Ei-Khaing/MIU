package unidirectional.onetozeroonefactory;

public class ShoppingCart {
	private ShoppingCart(Customer cust) {
		cust.setShoppingCart(this);
	}

	public static ShoppingCart newShoppingCart(Customer cust) {
		if(cust == null)
			throw new NullPointerException("Customer should not be null");
		return new ShoppingCart(cust);
	}
}
