package lists.linkedlist.singlelinkedlist;

public class SingleLinkedListApp {

	public static void main(String[] args) {
//		var list = new SingleLinkedList<Integer>();
		var list = new SingleLinkedListWithTail<Integer>();
		// add
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		list.addFirst(0);
		list.addFirst(-1);
		list.addFirst(-2);
		list.addFirst(-3);
		System.out.println(list);
		
//		System.out.println(list);
//		list.add(0);
//		System.out.println(list);
//		list.addFirst(-1);
//		System.out.println(list);
//		list.add(1);
//		System.out.println(list);
//		list.addFirst(-2);
//		System.out.println(list);
//		list.add(2);
//		System.out.println(list);
	}

}
