package finalexampreparation;

import java.util.Arrays;

public class RecursionPracticeArrayContainsApp {

	public static void main(String[] args) {
		var arr = new String[]{"Anna", "Bob", "Carlos", "Dave", "Erin", "Fred"};
		var target1 = "Dave";
		var target2 = "Alice";
		var result1 = arrayContainsRecursively(arr, target1); // Expected result: true
		var result2 = arrayContainsRecursively(arr, target2); // Expected result: false
		System.out.println("////=== WITH RECURSION ====////");
		System.out.printf("The array, %s, contains target string, %s: %s\n", 
				Arrays.toString(arr), target1, result1);
		System.out.printf("The array, %s, contains target string, %s: %s\n", 
				Arrays.toString(arr), target2, result2);
		var result3 = arrayContainsIteratively(arr, target1); // Expected result: true
		var result4 = arrayContainsIteratively(arr, target2); // Expected result: false
		System.out.println("////=== WITH ITERATION ====////");
		System.out.printf("The array, %s, contains target string, %s: %s\n", 
				Arrays.toString(arr), target1, result3);
		System.out.printf("The array, %s, contains target string, %s: %s\n", 
				Arrays.toString(arr), target2, result4);
	}

	/**
	 * Uses Recursion technique to check if the target string is contained in
	 * the given array of strings
	 * @param arr the given array of strings
	 * @param target the target string
	 * @return true if target is contained in array, otherwise, false
	 */
	private static boolean arrayContainsRecursively(String[] arr, String target) {
		if(arr.length<=0) 
			return false;
		String firstString=arr[0];
		if(firstString.equals(target)) 
			return true;
		else
		{
			String[] newArr=new String[arr.length-1];
			System.arraycopy(arr, 1, newArr, 0, arr .length-1);
			
			return arrayContainsRecursively(newArr, target);
		}
	}
	
	/**
	 * Uses Iteration technique to check if the target string is contained in
	 * the given array of strings
	 * @param arr the given array of strings
	 * @param target the target string
	 * @return true if target is contained in array, otherwise, false
	 */
	private static boolean arrayContainsIteratively(String[] arr, String target) {
		for(String s : arr) {
			if(s.equals(target))
				return true;
		}
		return false;
	}

}
