package lesson11.labs.prob5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondSmallest {
	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(0, 8, 5, 4, 2, 7, 21, 19);
		List<String> strings = Arrays.asList("CCC", "FFF", "GGG", "RRR", "TTT", "BBB");
		
		System.out.println(secondSmallest(ints));
		System.out.println(secondSmallest(strings));

		System.out.println("===========");
		System.out.println(secondSmallest2(ints, (a, b) -> a > b ? 1 : a == b ? 0 : -1));
		System.out.println(secondSmallest2(strings, (a, b) -> a.compareTo(b)));

		System.out.println("===========");
		System.out.println(secondSmallest3(ints, (a, b) -> a > b ? 1 : a == b ? 0 : -1));
		System.out.println(secondSmallest3(strings, (a, b) -> a.compareTo(b)));

	}

	public static <T extends Comparable<T>> T secondSmallest(List<T> list) {
		T smallest = list.get(0);
		T secondSmallest = list.get(0);
		for (T item : list) {
			if (smallest.compareTo(item) > 0) {
				secondSmallest = smallest;
				smallest = item;
			} else if (secondSmallest.compareTo(smallest) == 0
					|| (item.compareTo(smallest) > 0 && item
							.compareTo(secondSmallest) < 0)) {
				secondSmallest = item;
			}
		}

		return secondSmallest;
	}

	public static <T extends Comparable<T>> T secondSmallest2(List<T> list,
			Comparator<T> comparator) {
		T smallest = list.get(0);
		T secondSmallest = list.get(0);
		for (T item : list) {
			if (comparator.compare(smallest, item) > 0) {
				secondSmallest = smallest;
				smallest = item;
			} else if (secondSmallest.compareTo(smallest) == 0
					|| (comparator.compare(item, smallest) > 0 && comparator
							.compare(item, secondSmallest) < 0)) {
				secondSmallest = item;
			}
		}

		return secondSmallest;
	}


	public static <T extends Comparable<T>> T secondSmallest3(List<? extends T> list,
			Comparator<? super T> comparator) {
		T smallest = list.get(0);
		T secondSmallest = list.get(0);
		for (T item : list) {
			if (comparator.compare(smallest, item) > 0) {
				secondSmallest = smallest;
				smallest = item;
			} else if (secondSmallest.compareTo(smallest) == 0
					|| (comparator.compare(item, smallest) > 0 && comparator
							.compare(item, secondSmallest) < 0)) {
				secondSmallest = item;
			}
		}

		return secondSmallest;
	}
}
