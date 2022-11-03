package exercise1;

import java.util.Comparator;
public class CompareLibrary {
	static Comparator<Customer> cusComp 
	   = Comparator.comparing((Customer c) -> c.getLastName());
	public static int compareCus(Customer c1, Customer c2) {
		return cusComp.compare(c1, c2);
	}
}
