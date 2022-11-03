package Final.prob2.exam.partC;

import java.util.Comparator;

//The lambda:   (Long a, Long b) -> a.compareTo(b)
//NOTE: You may NOT type this as a BiFunction
public class PartC {
	
	//provide a functional interface type for the lambda - do NOT use BiFunction
	Comparator<Long> c = (Long x, Long y)->x.compareTo(y);
	
	//provide a method reference and the type of method reference
	//TYPE: Class::Static
	Comparator<Long> c1=Long::compareTo;
	
	// provide an inner class that behaves the same way as the labmda
	//class My--- implements --- { }
	class c2 implements Comparator<Long>{

		@Override
		public int compare(Long o1, Long o2) {
			return o1.compareTo(o2);
		}
	}
		
	
	public void evaluator() {
		System.out.println(c.compare(Long.valueOf(1000), Long.valueOf(200)));
		System.out.println(c1.compare(Long.valueOf(1000), Long.valueOf(200)));
		System.out.println((new c2()).compare(Long.valueOf(1000), Long.valueOf(200)));
	}
	
	public static void main(String[] args) {
		PartC pa = new PartC();
		pa.evaluator();
	}
}
