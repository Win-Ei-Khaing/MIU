package sortings;

import java.util.Arrays;

public class InsertionSort {

	public static void sort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		int j = 0;
		for(int i=1; i<len; ++i) {
			temp = arr[i];
			j = i;
			while(j>0 && temp<arr[j-1]) {
				arr[j] = arr[j-1];
				System.out.println(Arrays.toString(arr));
				j--;
			}
			arr[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,5,6,3,7,3,23,54,35,65,4};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
