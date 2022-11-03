package lesson9.labs.prob1;

import java.util.stream.IntStream;

public class partA {
	public static void main(String[] args) {
		IntStream ones = IntStream.generate(() -> 1).limit(10);
		ones.forEach(System.out::println);
	}
}
