package question11;

import java.util.Arrays;

public class SmallestFinderApp {

	public static void main(String[] args) {
		//var arr0 = null; As I'm getting compiler error at var, I changed with int[] for type declaration
		int[] arr0 = null;
		var arr1 = new int[] {};
		var arr2 = new int[]{8, 94, -5, 19, 2, 10};

		
		//var result0 = findSmallestRecursively(arr0); // Expected result: should throw IllegalArgumentException
		//var result1 = findSmallestRecursively(arr1); // Expected result: should throw IllegalArgumentException
		var result2 = findSmallestRecursively(arr2); // Expected result: -5
		
		System.out.println("////=== WITH RECURSION ====////");
		System.out.printf("The smallest in array, %s, is: %d\n", 
				Arrays.toString(arr2), result2);
		
		var result3 = findSmallestIteratively(arr0); // Expected result: should throw IllegalArgumentException
		var result4 = findSmallestIteratively(arr1); // Expected result: should throw IllegalArgumentException
		var result5 = findSmallestIteratively(arr2); // Expected result: -5
		
		System.out.println("////=== WITH Iteration ====////");
		System.out.printf("The smallest in array, %s, is: %d\n", 
				Arrays.toString(arr2), result5);

	}

	/**
	 * Uses Recursion technique to find the smallest integer from
	 * the given array of integers
	 * @param arr the given array of integers
	 * @return the smallest value, if present
	 */
	private static int findSmallestRecursively(int[] arr) {
		// TODO 1: (3points) Implement your recursive solution here
		if(arr == null || arr.length < 1) throw new IllegalArgumentException();
		if(arr.length == 1) return arr[0];
		return findSmallestRecursively(arr, arr.length);
	}
	
	private static int findSmallestRecursively(int[] arr, int len){
		if(len == 1) return arr[0];
		int min=findSmallestRecursively(arr, len-1);
		if(min > arr[len-1])
			min = arr[len-1];
		return min;
	}
	/**
	 * Uses Iteration technique to find the smallest integer from
	 * the given array of integers
	 * @param arr the given array of integers
	 * @return the smallest value, if present
	 */
	private static int findSmallestIteratively(int[] arr) {
		// TODO 2:(2points) Implement your iterative solution here
		if(arr == null || arr.length < 1) throw new IllegalArgumentException();
		int min=arr[0];
		for(int i=1; i<arr.length; i++) {
			if(min>arr[i])
				min=arr[i];
		}
		return min;
	}

}