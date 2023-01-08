package problem02;

import java.util.Arrays;

public class MergeSorted {
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] combined = new int[n+m];
		int i=0, j=0, k=0;
		while(i<n && j<m) {
			if(arr1[i]<arr2[j]) {
				combined[k] = arr1[i];
				i++;
			}
			else {
				combined[k] = arr2[j];
				j++;
			}
			k++;
		}
		while(i<n) {
			combined[k] = arr1[i];
			k++; i++;
		}
		while(j<m) {
			combined[k] = arr2[j];
			k++; j++;
		}
		return combined;
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {1, 4, 5, 8, 17};
		int[] arr2 = new int[] {2, 4, 8, 11, 13, 21, 23, 25};
		String combined = Arrays.toString(merge(arr1, arr2));
		System.out.println(combined);
	}
}
