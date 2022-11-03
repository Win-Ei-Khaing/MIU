package iterate;
import java.math.BigInteger;
import java.util.stream.*;
public class Examples {

	public static void main(String[] args) {
		Stream<String> stream0 = Stream.generate(() -> "Echo ");
		Stream<BigInteger> stream1 = 
			Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
		
		Stream<Integer> stream2 =
			Stream.iterate(1, n -> n + 1);
		
		stream0.limit(5).collect(Collectors.toList()).forEach(System.out::print);
		System.out.println("\n");
		stream1.limit(5).collect(Collectors.toList()).forEach(System.out::print);
		System.out.println("\n");
		stream2.limit(5).collect(Collectors.toList()).forEach(System.out::print);
	
		System.out.println("\n");
		Stream<Character> charStream = Stream.concat(Stream.of('a','b','c'), Stream.of('d','e','f'));
		System.out.println(charStream.collect(Collectors.toList()));
		
		System.out.println(Stream.iterate(1, x->x+2).limit(10).skip(4).collect(Collectors.toList()));
	}

}
