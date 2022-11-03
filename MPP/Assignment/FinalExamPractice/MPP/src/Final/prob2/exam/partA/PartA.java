package Final.prob2.exam.partA;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//The lambda:   () -> Math.random()
public class PartA {
	// provide a functional interface type for the lambda
	Supplier<Double> random = () -> Math.random();

	// provide a method reference and the type of method reference
	// TYPE: class::staticMethod
	Supplier<Double> random2 = Math::random;

	// provide an inner class that behaves the same way as the labmda
	// class MyClass implements ... { }
	class MyRandom implements Supplier<Double> {

		@Override
		public Double get() {
			// TODO Auto-generated method stub
			return Math.random();
		}

	}
	
	
	BiPredicate<Double, Double> predicate = (Double x, Double y)->(x*y)<(x+y);
	BiPredicate<Double, Double> predicate1 = PartA::helperForTest;
	
	BiPredicate<Double, Double> predicate2=new BiPredicate<Double, Double>(){
		@Override
		public boolean test(Double x, Double y) {
			// TODO Auto-generated method stub
			return x*y<x+y;
		}
	};
	
	public static Boolean helperForTest(Double x, Double y) {
		return x*y<x+y;
	}
	
	class Test implements BiPredicate<Double, Double>{

		@Override
		public boolean test(Double x, Double y) {
			// TODO Auto-generated method stub
			return x*y<x+y;
		}
		
	}
	
	public void evaluator() {
		// implement the lambda, the method reference, and the inner class
		// operation
		System.out.println(random.get());
		System.out.println(random2.get());
		System.out.println((new MyRandom()).get());
		
		System.out.println(predicate.test(100.0,1.4));
		System.out.println(predicate1.test(1.2,1.4));
		System.out.println(predicate2.test(1.2,1.4));
		System.out.println(new Test().test(1.2, 0.0));
	}

	public static void main(String[] args) {
		PartA pa = new PartA();
		pa.evaluator();
	}
}