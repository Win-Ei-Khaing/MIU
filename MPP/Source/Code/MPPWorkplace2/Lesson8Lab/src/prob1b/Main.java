package prob1b;

import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		Supplier<Double> methodRef = Math::random;
		System.out.println(methodRef.get());
		
		Supplier<Double> lambda = ()->Math.random();
		System.out.println(lambda.get());
		
		Main main = new Main();
		InnerTestClass inner = main.new InnerTestClass();
		System.out.println(inner.get());
	}
	
	@SuppressWarnings("rawtypes")
	class InnerTestClass implements Supplier{
		@Override
		public Object get() {
			return Math.random();
		}
		
	}
}
