package lesson5.interfaces;

public interface Iface2 {
	int myMethod(int x);
	
	default void dMethod() {
		System.out.println("default method in i face 2");
	};
}
