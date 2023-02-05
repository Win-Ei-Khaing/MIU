package lesson7testing;

import java.util.Arrays;

public class SumTesting {
	public static void main(String[] args) {
		int[] a=new int[] {1,2,3,4,5,6,7,8,9};

		System.out.printf("The sum of numbers in array, %s is : %d. \n", Arrays.toString(a), calcSumUsingIteration(a));
		System.out.printf("The sum of numbers in array, %s is : %d. \n", Arrays.toString(a), calcSumUsingRecursion(a));
	}

	public static int calcSumUsingIteration(int[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		return sum;
	}

	public static int calcSumUsingRecursion(int[] a) {
		if(a.length==1) return a[a.length-1];
		int[] newAry=new int[a.length-1];
		System.arraycopy(a, 1, newAry, 0, a.length-1);
		return a[0]+calcSumUsingRecursion(newAry);
	}
}
