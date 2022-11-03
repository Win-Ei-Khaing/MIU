package lesson11.exercise_2;

import java.util.stream.Stream;

public class CountStringOccurrences {
	public static int countOccurrences(String[] arr, String target) {
		int count = 0;
		if (target == null) {
			for (String item : arr) {
				if (item == null) {
					count++;
				}
			}
		} else {
			for (String item : arr) {
				if (target.equals(item)) {
					count++;
				}
			}
		}
		return count;
	}

	//implemented by win
	public static <T> int countOccurrencesByGeneric(T[] arr, String target) {
		//return Stream.of(arr).filter(x->x.equals(target)).count();
		int count=0;
		for(T t:arr) {
			if(t.equals(target)) {
				count++;
			}
		}
		return count;
	}
	
	public static <T> int countOccurrencesByStream(T[] arr, String target) {
		return (int) Stream.of(arr).filter(x->x.equals(target)).count();
	}

	public static void main(String[] args) {
		String[] arr = new String[] {"Win", "Thae", "Su", "Khaing","Su"};
		System.out.println(countOccurrences(arr,"Su"));
		System.out.println(countOccurrencesByGeneric(arr,"Su"));
		System.out.println(countOccurrencesByStream(arr,"Su"));
	}
}
