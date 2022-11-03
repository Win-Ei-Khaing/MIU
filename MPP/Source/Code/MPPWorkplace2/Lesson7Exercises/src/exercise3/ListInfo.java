package exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListInfo {
	List<String> list = new ArrayList<>();
	MyStringList strList = new MyStringList();
	public static void main(String[] args) {
		ListInfo li = new ListInfo();
		li.process();
	}

	public void process() {
		list.add("A");
		list.add("W");
		list.add("K");
		list.add("C");

		//use java8 foreach to copy all list elements into the array
	
		Consumer<String> cons = new Consumer<String>(){
			@Override
			public void accept(String t) {
				System.out.println(t);
				strList.add(t);
			}
		};
		list.forEach(cons);
		System.out.println("New list ------------");
		strList.forEach(System.out::println);
	}
}