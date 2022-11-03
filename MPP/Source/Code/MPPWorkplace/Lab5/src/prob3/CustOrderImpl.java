package prob3;

final class CustOrderImpl implements CustOrder{
	private Customer customer;
	private Order order;
	
	CustOrderImpl(Customer customer, Order order){
		this.customer = customer;
		this.order = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Order getOrder() {
		return order;
	}
}
