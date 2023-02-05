package prog7_1;

public class Exponential {
	double power(double x, int n) {
		if(n<0) return 0; //as n must be any natural number greater than 0 in question
		if(n==0) return 1;
		return x*power(x, n-1);
	}
	
	public static void main(String[] args) {
		Exponential e=new Exponential();
		System.out.println(e.power(2, 10));
	}
}
