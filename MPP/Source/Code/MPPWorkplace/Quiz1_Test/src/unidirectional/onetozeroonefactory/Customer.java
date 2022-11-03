package unidirectional.onetozeroonefactory;

public class Customer {
	private ShoppingCart shoppingCart;

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
}
