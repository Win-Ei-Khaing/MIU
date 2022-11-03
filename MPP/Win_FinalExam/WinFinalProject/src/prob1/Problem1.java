package prob1;

import java.util.function.BiPredicate;

//work with this lambda expression:   (Double x, Double y) -> x * y < x + y
//implemented by Win

public class Problem1 {
	// name and type of lambda goes here
	BiPredicate<Double, Double> lambda = (x, y)->x*y<x+y;
	
	
	// representing lambda as a method reference
	//Class::staticMethod
	BiPredicate<Double, Double> methodRef = Problem1::helperForTest;
	
	public static Boolean helperForTest(Double x, Double y) {
		return x*y<x+y;
	}
	
	//representing lambda as a static nested class
	public static class InnerClass implements BiPredicate<Double, Double>{
		@Override
		public boolean test(Double x, Double y) {
			return x*y<x+y;
		}
	}
	
	//evaluate with Double inputs 2.1, 0.35
	public void evaluator() {
//		System.out.println(2.1*0.35<2.1+0.35);
		
		System.out.println(lambda.test(2.1, 0.35));
		System.out.println(methodRef.test(2.1, 0.35));
		System.out.println((new InnerClass()).test(2.1, 0.35));
		
//		System.out.println(3.0*4.0<3.0+4.0);
//		System.out.println(lambda.test(3.0, 4.0));
//		System.out.println(methodRef.test(3.0, 4.0));
//		System.out.println((new InnerClass()).test(3.0, 4.0));
	}
	public static void main(String[] args) {
		Problem1 p = new Problem1();
		p.evaluator();
	}
	
	
}
