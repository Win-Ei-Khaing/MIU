package lesson5.interfaces;

public class MyClass implements Iface1, Iface2{

	@Override
	public int myMethod(int x) {
		return x + 1;
	}

	public static void main(String[] args) {
		Iface1 mc = new IfaceImpl2();
		System.out.println(mc.myMethod(3));
	}
}
