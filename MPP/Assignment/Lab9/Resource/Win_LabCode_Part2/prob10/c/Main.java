package c;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Stream<Integer> myIntStream = Stream.of(1,10,2,30,3,30);
		IntSummaryStatistics summary = myIntStream.collect(Collectors.summarizingInt(x->x));
		System.out.println("Max is : "+summary.getMax());
		System.out.println("Min is : "+summary.getMin());
	}
}
