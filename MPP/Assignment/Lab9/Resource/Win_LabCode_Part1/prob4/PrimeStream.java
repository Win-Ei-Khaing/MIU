import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeStream {
	final Supplier<Stream<BigInteger>> primes=() -> Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
	
	public static void main(String[] args) {
		PrimeStream ps = new PrimeStream(); 

		ps.printFirstNPrimes(5);
		System.out.println("====");
		ps.printFirstNPrimes(10);
		System.out.println("====");
	}

	public void printFirstNPrimes(long n) {
		System.out.println(primes.get().limit(n).collect(Collectors.toList()));
	}
}


