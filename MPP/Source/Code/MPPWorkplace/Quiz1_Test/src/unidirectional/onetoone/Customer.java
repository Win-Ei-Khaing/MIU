package unidirectional.onetoone;

public class Customer {
	private ShoppingCart shoppingCart;

	public Customer(){
		shoppingCart=new ShoppingCart();
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
}
