package lists.arraylist;

public class MyArrayListWithIterableAndPeekingIteratorDemoApp {

	public static void main(String[] args) {
		var list = new MyArrayListWithIterableAndPeekingIterator<Integer>();
		var pkIt = list.iterator();
		System.out.println(list);
//		System.out.println(pkIt.peek()); // NoSuchElementException
		list.add(1);
		list.add(2);
		list.add(3);
		list.print();
		System.out.println(list.get(0));
		System.out.println(list);
		System.out.println(pkIt.peek()); // 1
		System.out.println(pkIt.peek()); // 1
		System.out.println(pkIt.next()); // 1
		System.out.println(pkIt.peek()); // 2
		System.out.println(pkIt.next()); // 2
		System.out.println(pkIt.peek()); // 3
		System.out.println(pkIt.next()); // 3
//		System.out.println(pkIt.peek()); // NoSuchElementException
		list.forEach(System.out::println);
	}

}
