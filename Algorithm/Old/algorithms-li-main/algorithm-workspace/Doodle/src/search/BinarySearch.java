package search;

import java.util.Arrays;

public class BinarySearch {
	public static <T extends Comparable<T>> boolean searchHelper(T t, T[] arr, int lower, int upper) {
		if (lower > upper)
			return false;
		int mid = (upper + lower) / 2;
		if (arr[mid].compareTo(t) == 0)
			return true;
		else if (arr[mid].compareTo(t) > 0)
			return searchHelper(t, arr, lower, mid - 1);
		else
			return searchHelper(t, arr, mid + 1, upper);

	}

	public static <T extends Comparable<T>> boolean search(T t, T[] arr) {
		int upper = arr.length - 1;
		int lower = 0;
		return searchHelper(t, arr, lower, upper);
	}

	public static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 3, 5, 7, 12, 23, 32, 34, 36, 43, 62, 67, 74, 85 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Integer target = 40;
		System.out.println(search(target, arr));
	}
}
