package factory;

public class ConcreteProduct implements Product{
	private String productName;
	
	ConcreteProduct(String productName){
		this.productName=productName;
	}
	
	
	//factory
	
//	private ConcreteProduct(String productName){
//		this.productName=productName;
//	}
//	
//	public static ConcreteProduct getNewConcreteProduct(String pName) {
//		return new ConcreteProduct(pName);
//	}
//	
	@Override
	public String getProductName() {
		return productName;
	}
}
