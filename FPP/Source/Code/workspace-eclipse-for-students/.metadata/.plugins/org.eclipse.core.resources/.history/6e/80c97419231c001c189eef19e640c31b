package list;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		/*var list=new SinglyList<Character>();
		list.addFirst('A');
		list.addFirst('B');
		list.addFirst('C');
		System.out.println(list.toString());*/

		var list=new SinglyListWithSentinel<Character>();
		list.addFirst('A');
		list.addFirst('B');
		list.addFirst('C');
		System.out.println(list.toString());
		
		Iterator<Character> e=list.iterator();
		while(e.hasNext())
			System.out.println(e.next());
		//list.forEach(c -> System.out.println(c)); 
	}
}
