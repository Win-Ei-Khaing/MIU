package lesson9.labs.prob4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Prob4 {
	public static void main(String[] args) {
		printSquares(4);
	}

	public static void printSquares(int num) {
		int[] squaresArr = IntStream.iterate(1, n -> n + 1).map(n -> n * n)
				.limit(num).toArray();

		System.out.println(Arrays.toString(squaresArr));
	}
}
