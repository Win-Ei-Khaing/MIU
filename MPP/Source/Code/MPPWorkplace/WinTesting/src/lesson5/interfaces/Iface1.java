package lesson5.interfaces;

public interface Iface1 {
	int myMethod(int x);
	
	default void dMethod() {
		System.out.println("default method in iface1");
	};
}
