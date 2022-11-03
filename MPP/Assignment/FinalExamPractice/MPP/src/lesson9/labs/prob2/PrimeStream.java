package lesson9.labs.prob2;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeStream {

	private static final Supplier<Stream<BigInteger>> primes = () -> Stream
			.iterate(new BigInteger("2"), n -> n.nextProbablePrime());

	public static void main(String[] args) {
		PrimeStream ps = new PrimeStream();
		ps.printFirstNPrimes(10);
		System.out.println("====");
		ps.printFirstNPrimes(5);
	}

	private void printFirstNPrimes(int limit) {
		System.out.println(primes.get().limit(limit)
				.collect(Collectors.toList()));
	}

}
