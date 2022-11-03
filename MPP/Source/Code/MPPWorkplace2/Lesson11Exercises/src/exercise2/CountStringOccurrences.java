package exercise2;

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
	public static <T> int countOccurrencesByGeneric(T[] arr, T target) {
		//return Stream.of(arr).filter(x->x.equals(target)).count();
		int count=0;
		if (target == null) return 0;
		for(T t:arr) {
			if(t.equals(target)) {
				count++;
			}
		}
		return count;
	}
	
	public static <T> int countOccurrencesByStream(T[] arr, String target) {
		/*return (int) Stream.of(arr).filter(x->{
			if(target==null) return (x==null);
			return x.equals(target);
		}).count();*/
		
//		return (int) Stream.of(arr).filter(x->{
//			if(target==null) return (x==null);
//			else return target.equals(x);
//		}).count();
		return (int) Stream.of(arr).filter(x->x.equals(target)).count();
	}

	public static void main(String[] args) {
		String[] arr1 = new String[] {"Win", "Thae", "Su", "Khaing","Su"};
		System.out.println(countOccurrences(arr1,"Su"));
		System.out.println(countOccurrencesByGeneric(arr1,"Su"));
		System.out.println(countOccurrencesByStream(arr1,null));
		
		
		String[] arr = {"a", "b", "c", "b"};
		System.out.println(countOccurrences(arr, "b"));
		System.out.println(countOccurrences(arr, "b"));
		
		Object[] arr2 = {"a", null, "c", null};
		System.out.println(countOccurrencesByGeneric(arr2, null));
		System.out.println(countOccurrencesByGeneric(arr2, null));
	}
}
