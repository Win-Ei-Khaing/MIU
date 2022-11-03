package exercise2;

import java.util.Random;

public class MyRandGen implements MyIface {
	@Override
	public int produce() {
		Random r = new Random();
		return r.nextInt();
	}

	public static void main(String[] args) {
		MyIface g = new MyRandGen();
		System.out.println(g.produce());
		
		System.out.println("Using lamba");
		MyIface a = ()->{
			Random r = new Random();
			return r.nextInt();
		};
		System.out.println(a.produce());
	}
}
