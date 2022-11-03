package lesson5.interfaces;

public class IfaceImpl1 implements Iface1{

	@Override
	public int myMethod(int x) {
		System.out.println("always return 1 from iFaceImpl1");
		return 1;
	}

}
