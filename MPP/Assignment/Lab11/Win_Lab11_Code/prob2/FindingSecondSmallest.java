package prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingSecondSmallest {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(0);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		System.out.println(secondSmallest(intList));

		List<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		System.out.println(secondSmallest(strList));
	}

	public static <T extends Comparable<T>> T secondSmallest(List<T> list) {
		if(list.size()<2) return null;
		Collections.sort(list);
		return list.get(1);
	}
}
