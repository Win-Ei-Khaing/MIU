package lesson5.interfaces;

public class IfaceImpl12 implements Iface1, Iface2{

	@Override
	public int myMethod(int x) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	@Override
	public void dMethod() {
		// TODO Auto-generated method stub
		Iface2.super.dMethod();
		System.out.println("dd");
	}



	public static void main(String[] args) {
		IfaceImpl12 aa = new IfaceImpl12();
		System.out.println(aa.myMethod(100));
		aa.dMethod();
	}
}
