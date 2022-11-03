package lesson11.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Reverse {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		stringList.add("One");
		stringList.add("Two");
		stringList.add("Three");
		stringList.add("Four");
		stringList.add("Five");
		stringList.add("Six");
		stringList.add("Seven");
		reverse(stringList);

		System.out.println(stringList);
	}

	public static void reverse(List<?> list) {
		resverseHelper(list);
		
		//Instead of capturing the type in new method 
		//final List l = list;
	}

	public static <T> void resverseHelper(List<T> list) {
		int m = list.size();
		for (int i = 0; i < m/2; i++) {
			T temp = list.get(i);
			list.set(i, list.get(m - i-1));
			list.set(m - i-1,temp);
		}
	}

}
