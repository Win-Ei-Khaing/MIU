package student;

public class Main {
	public static void main(String[] args) {
		int[] a = { 1, 4, 2, 3 };
		int[] b = { 3, 3, 4, 7 };
		int[] c = { 9 };
		System.out.println(secondSmallest(a));
		System.out.println(secondSmallest(b));
		System.out.println(secondSmallest(c));
	}

	public static int secondSmallest(int[] arr) {
		int small = arr[0], smaller = arr[0];
		if (arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Input array too small");
		}
		for (int i = 0; i < arr.length; i++) {
			if (smaller <= arr[i]) {
				smaller = small;
				smaller = arr[i];
			}
		}
		// implement
		return small;
	}
}
