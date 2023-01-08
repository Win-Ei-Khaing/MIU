package student;

public class GCD {

	public static int gcd(int m, int n) {
		int num;
		int maxfactorial = 0;
		if (m < n) {
			num = m;
		} else {
			num = n;
		}
		for (int i = 1; i <= num; i++) {
			if (m % i == 0) {
				if (n % i == 0) {
					if (i > maxfactorial) {
						maxfactorial = i;
					}
				}
			}
		}
		return maxfactorial;
	}

	public static int secondSmallest(int[] arr) {
		if (arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Input array too small");
		}
		int smallest = arr[0];
		int secondSmallest = arr[1];
		if (smallest > secondSmallest) {
			int temp = smallest;
			smallest = secondSmallest;
			secondSmallest = temp;
		}
		for (int i = 2; i < arr.length; ++i) {
			int next = arr[i];
			if (next < smallest) {
				secondSmallest = smallest;
				smallest = next;
			} else if (next < secondSmallest) {
				secondSmallest = next;
			}

		}
		return secondSmallest;
	}

	public static void main(String[] args) {
		System.out.println(gcd(42, 12));
		System.out.println(secondSmallest(new int[] {3,5,7,25}));
	};
}