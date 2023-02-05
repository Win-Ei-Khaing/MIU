package lesson7testing;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] ary=new int[] {1,2,3,4,5};
		System.out.println(Arrays.toString(ary));
		
		System.out.println("After sorting : \n"+Arrays.toString(reverse(ary)));
	}

	static int[] reverse(int[] ary) {
		int index=0;
		int lastIndex=ary.length-1;
		while(index<lastIndex) {
			int temp=ary[lastIndex];
			ary[lastIndex]=ary[index];
			ary[index]=temp;
			index++;
			lastIndex--;
		}
		return ary;
	}
}
