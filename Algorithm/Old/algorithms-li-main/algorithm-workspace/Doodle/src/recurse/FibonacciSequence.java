package recurse;

import java.math.BigInteger;

public class FibonacciSequence {

	public static BigInteger fib1(int a) {
		if(a <= 1)
			return new BigInteger(""+a);
		return fib1(a-1).add(fib1(a-2));
	}
	
	public static BigInteger fib2(int a) {
		BigInteger prev = new BigInteger("0");
		BigInteger curr = new BigInteger("1");
		BigInteger next;
		for(int i=0; i<a; i++) {
			next = prev.add(curr);
			prev = curr;
			curr = next;
		}
		return prev;
		
	}
	
	public static BigInteger fib3(int a) {
		if(cache[a] != null)
			return cache[a];
		if(a <= 1)
			return new BigInteger(""+a);
		BigInteger x = fib3(a-1).add(fib3(a-2));
		cache[a] = x;
		return x;
	}
	
	static BigInteger[] cache;
	public static BigInteger fastfib(int a) {
		cache = new BigInteger[a+1];
		return fib3(a);
	}
		
	
	public static void main(String[] args) {
//		System.out.println(fib1(20));
		System.out.println(fib2(47));
		System.out.println(fastfib(47));
	}
}
