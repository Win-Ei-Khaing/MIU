package lesson2.nums;

public class Main {

	public static void main(String[] args) {
		int x = (int)Math.pow(2, 30);
		System.out.println(x);
		System.out.println(x + x);
		System.out.println("0" + Integer.toBinaryString(x) + " length: " + ("0"+Integer.toBinaryString(x)).length());
		System.out.println(Integer.toBinaryString(x+x) + " length: " + Integer.toBinaryString(x+x).length());
		long y = (long)Math.pow(2, 31);
		System.out.println(y);
		System.out.println("..." + Long.toBinaryString(y) + " length: " + Long.toBinaryString(y).length());
		y = y-1;
		System.out.println(y);
		System.out.println("...0" + Long.toBinaryString(y) + " length: " + ("0"+Long.toBinaryString(y)).length());
		int z = (int)y;
		System.out.println(z);
		System.out.println("0" + Long.toBinaryString(z) + " length: " + ("0"+Long.toBinaryString(z)).length());
	}

}
