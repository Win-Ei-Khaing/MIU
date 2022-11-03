package exercise1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		List<Integer> intList1 = Stream.iterate(1, n -> n + 2)
				.limit(10)
				.collect(Collectors.toList());
		System.out.println(intList1.toString());
		
		List<Integer> intList2 = Stream.iterate(1, n -> n + 2)
				.limit(8)
				.skip(4)
				.collect(Collectors.toList());
		System.out.println(intList2.toString());
	}
}
