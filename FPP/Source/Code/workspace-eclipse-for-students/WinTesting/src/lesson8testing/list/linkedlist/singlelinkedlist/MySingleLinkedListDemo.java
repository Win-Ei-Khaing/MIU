package lesson8testing.list.linkedlist.singlelinkedlist;

public class MySingleLinkedListDemo {
	public static void main(String[] args) {
		var l=new MySingleLinkedList<Integer>();
		System.out.println(l.toString());
		l.add(1);
		System.out.println(l.toString());
		l.add(2);
		System.out.println(l.toString());
		l.add(3);
		System.out.println(l.toString());
	}
}
