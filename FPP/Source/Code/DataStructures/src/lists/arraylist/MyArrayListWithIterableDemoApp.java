package lists.arraylist;

public class MyArrayListWithIterableDemoApp {

	public static void main(String[] args) {
		var list = new MyArrayListWithIterable<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.print();
		System.out.println(list.get(0));
		System.out.println(list);
		list.forEach(System.out::println);
	}

}
