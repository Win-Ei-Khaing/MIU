package sortings;

import java.util.Arrays;

public class BubbleSort {
	public static <T extends Comparable<? super T>> void sort(T[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j].compareTo(arr[j+1])>0)
					swap(arr, j, j+1);
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		Character[] charArr = new Character[] {'a','c', 'd', 'c','z', 'b', 'm'};
		sort(charArr);
		System.out.println(Arrays.toString(charArr));
		
		Integer[] intArr = new Integer[] {1,4,6,3,7,3,0};
		sort(intArr);
		System.out.println(Arrays.toString(intArr));
		
	}
}

