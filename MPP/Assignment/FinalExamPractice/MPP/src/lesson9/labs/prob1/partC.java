package lesson9.labs.prob1;

import java.util.function.Function;
import java.util.stream.IntStream;

public class partC {
	
	private static final Function<int[], IntStream> intStreamList=list-> IntStream.of(list);
	
	
	public static void main(String[] args) {
		int[] numbers= new int[]{ 3,4,7,19,82,23,12,45,2,8};
		System.out.println(intStreamList.apply(numbers).max().getAsInt());
		System.out.println(intStreamList.apply(numbers).min().getAsInt());
	}
	
}
