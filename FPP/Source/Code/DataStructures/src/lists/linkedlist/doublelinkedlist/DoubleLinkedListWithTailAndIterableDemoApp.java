package lists.linkedlist.doublelinkedlist;

import java.util.Iterator;

public class DoubleLinkedListWithTailAndIterableDemoApp {

	public static void main(String[] args) {
		var list =  new DoubleLinkedListWithTailAndIterable<Integer>();
		list.printAll();
		System.out.printf("Size: %d\n", list.size());
		list.add(1);
		System.out.println(list);
		System.out.printf("Size: %d\n", list.size());
		list.add(2); list.add(3); list.add(4);
		System.out.println(list);
		System.out.printf("Size: %d\n", list.size());
//		list.printAllInReverse();
//		// Using the Iterator
		list.forEach(n -> System.out.print(n + " "));
//		System.out.println();
//		// Try get(...)
//		System.out.printf("3rd element: %d\n", list.get(2));
		// 3 ways to iterate a collection
		
		// Use the Iterator with for...loop
		for(Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		
		// Use the Iterator with while...loop
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// Enhance for...loop
		for(Integer n : list) {
			System.out.println(n);
		}
	}

}
