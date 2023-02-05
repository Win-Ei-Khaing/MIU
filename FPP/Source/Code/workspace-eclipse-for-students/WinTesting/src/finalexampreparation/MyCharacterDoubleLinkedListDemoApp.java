package finalexampreparation;

public class MyCharacterDoubleLinkedListDemoApp {

	public static void main(String[] args) {
		MyCharacterDoubleLinkedList list=new MyCharacterDoubleLinkedList();
		System.out.println(list.toString());
		list.addFirst('A');
		list.addFirst('B');
		list.addFirst('C');
		list.addFirst('D');
		list.addFirst('E');
		System.out.println(list.toString());
		list.printAllInReverse();
		
		System.out.printf("C is contained in the list? %s\n", list.contains('C'));
		System.out.printf("F is contained in the list? %s\n", list.contains('F'));
		
		list.forEach(c -> System.out.print(c+ " "));
	}

}