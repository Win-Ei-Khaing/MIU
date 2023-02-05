package question12;

public class AppMain {

	public static void main(String[] args) {
		IntegerSLList list = new IntegerSLList();
		System.out.println("Removed from empty list: " + list.removeFirst()); // prints: "null"   
		System.out.println("Max of empty list: " + list.findMax());
		list.addLast(1);
		list.addLast(2);	
		list.addLast(3);
		list.addLast(4);
//		System.out.println(list.removeFirst());
//		System.out.println(list.removeFirst());
//		System.out.println(list.removeFirst());		
//		System.out.println(list.removeFirst());		
//		System.out.println(list.removeFirst());	
//		System.out.println(list.removeFirst());	
		list.printAll(); // prints: [1=>2=>3=>4]
		System.out.println("Removed: " + list.removeFirst()); // prints: 1
		list.printAll(); // prints: [2=>3=>4]
		System.out.println("Max: " + list.findMax()); // prints: 4
	}
}
