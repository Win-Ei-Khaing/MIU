package lesson5.interfaces;

public class IfaceImpl2 implements Iface1{

	@Override
	public int myMethod(int x) {
		System.out.println("always return 0 from iFaceImpl2");
		return 0;
	}

}
