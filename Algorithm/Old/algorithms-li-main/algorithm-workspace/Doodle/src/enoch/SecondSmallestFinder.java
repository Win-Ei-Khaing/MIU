package enoch;

public class SecondSmallestFinder {
	public static int secondSmallest(int[] arr) {
		if(arr.length<2)
			throw new RuntimeException("No!");
		int smallest = arr[0];
		int secSmall = arr[0];
		for(int a: arr) {
			if(a == smallest)
				continue;
			if(a<smallest) {
				secSmall = smallest;
				smallest = a;
			}
			else if(a<secSmall) {
				secSmall = a;
			}
		}
		return secSmall;
	}
	
	public static void main(String[] args) {
		System.out.println(secondSmallest(new int[] {3,3,3,4,6}));
	}
}
