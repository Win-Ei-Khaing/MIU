package factory;

public class Factory {
	public static ConcreteProduct getNewConcreteProduct(String pName) {
		return new ConcreteProduct(pName);
	}
}
