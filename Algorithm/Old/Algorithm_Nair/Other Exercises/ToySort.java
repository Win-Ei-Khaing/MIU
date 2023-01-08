import java.util.Arrays;

public class ToySort {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void toySort(int[] A, int startIndex, int endIndex, int startColor, int endColor) {
		
		if (startColor == endColor || startIndex == endIndex) return;
		
		int lastLeftColor = (startColor + endColor)/2;
				
		int i = startIndex;
		int j = endIndex;
		
		while (i <= j) {
			while (i < endIndex & A[i] <= lastLeftColor) i++;
	        while (j > startIndex & A[j] > lastLeftColor) j--;
			if (i  < j)
				swap(A, i, j);
				i++;
				j--;
		}
	
		toySort(A, startIndex, i-1, startColor, lastLeftColor);
		toySort(A, i, endIndex, lastLeftColor + 1, endColor);	
	}
	
	public static void main(String[] args) {
		int first[] = new int[] {4, 2, 2, 3, 4, 1, 3, 2, 5, 4, 3, 4, 1, 4, 2};
		System.out.println(String.format("Before sorting : %s", Arrays.toString(first)));
        toySort(first,0, first.length - 1, 1, 5);
        System.out.println(String.format("Sorted array : %s", Arrays.toString(first)));
	}

}
