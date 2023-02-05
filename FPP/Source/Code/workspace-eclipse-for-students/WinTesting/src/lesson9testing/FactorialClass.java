package lesson9testing;

public class FactorialClass {
	static int fac(int i) {
		if(i<=1) return 1;
		return i*fac(i-1);
	}
	public static void main(String[] args) {
		for(int i=0;i<5;i++)
			System.out.println(fac(i));
	}
}
