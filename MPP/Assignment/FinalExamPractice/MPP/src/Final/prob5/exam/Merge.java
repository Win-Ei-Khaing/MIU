package Final.prob5.exam;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Merge {

	/* For testing your implementation */
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(2, 4, 6);
		List<Integer> list2 = Arrays.asList(3, 5, 6, 7);
		List<String> list3 = Arrays.asList("Alice", "Tom");
		List<String> list4 = Arrays.asList("Bob", "Richard");
		List<Double> list5 = Arrays.asList(2.3, 4.5);
		List<Number> list6 = Arrays.asList(2, 5);
		List<String> list7 = Arrays.asList("A", "XYZ", "AXTU");

		System.out.println(merge(list1, list2, (a, b) -> a.compareTo(b)));
		System.out.println(merge(list3, list4, (a, b) -> a.compareTo(b)));
		System.out.println(merge(list5, list6, (a, b) -> a.doubleValue() > b
				.doubleValue() ? 1 : a == b ? 0 : -1));
		
		System.out.println(merge(list7, list1, (a, b) -> {
			//System.out.println(a.toString()+"__"+b.toString());
			int aValue = a.getClass().equals(String.class) ? a.toString()
					.length() : Integer.parseInt(a.toString());
			int bValue = b.getClass().equals(String.class) ?b.toString()
					.length() : Integer.parseInt(b.toString());
			//System.out.println(aValue +"___"+ bValue);
			return aValue > bValue ? 1 : aValue == bValue ? 0 : -1;

		}));
		
		System.out.println("______________");
		System.out.println(merge1(list1, list2, (a, b) -> a.compareTo(b)));
		System.out.println(merge1(list3, list4, (a, b) -> a.compareTo(b)));
		System.out.println(merge1(list5, list6, (a, b) -> a.doubleValue() > b
				.doubleValue() ? 1 : a == b ? 0 : -1));
		
		System.out.println(merge1(list7, list1, (a, b) -> {
			//System.out.println(a.toString()+"__"+b.toString());
			int aValue = a.getClass().equals(String.class) ? a.toString()
					.length() : Integer.parseInt(a.toString());
			int bValue = b.getClass().equals(String.class) ?b.toString()
					.length() : Integer.parseInt(b.toString());
			//System.out.println(aValue +"___"+ bValue);
			return aValue > bValue ? 1 : aValue == bValue ? 0 : -1;

		}));
	}

	public static <T> List<T> merge1(List<? extends T> a, List<? extends T> b, Comparator<? super T> com){
		List<T> merge = new ArrayList<T>();
		merge.addAll(a);
		merge.addAll(b);
		
		merge=merge.stream()
				.sorted((x,y)->com.compare(x, y))
				.collect(Collectors.toList());
		
		return merge;
	}
	
	
	
	public static <T> List<T> merge(
			List<? extends T> list1, List<? extends T> list2,
			Comparator<? super T> comparator) {
		List<T> mergedList = new ArrayList<T>();
		mergedList.addAll(list1);
		mergedList.addAll(list2);

		mergedList = mergedList.stream()
				.sorted((a, b) -> comparator.compare(a, b))
				.collect(Collectors.toList());

		return mergedList;
	}
}
