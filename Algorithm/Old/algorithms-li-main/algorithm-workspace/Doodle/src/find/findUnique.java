package find;

public class findUnique {
	public static int findFirstUnique(int[] arr) {
		int max = 0;
		for(int m: arr)
			if(max<m)
				max = m;

		int[] bucket = new int[max+1];
		for(int i=0; i<arr.length; i++)
			bucket[arr[i]] += 1;
		for(int i=0; i<max; i++)
			if(bucket[i]==1)
				return i;
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(findFirstUnique(new int[] {3,3,4,1,7}));
	}
}
