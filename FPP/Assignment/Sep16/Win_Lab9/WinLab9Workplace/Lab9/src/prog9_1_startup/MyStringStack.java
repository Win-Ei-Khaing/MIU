package prog9_1_startup;

public class MyStringStack {
	private MyStringLinkedList list;
	public MyStringStack() {
		list = new MyStringLinkedList();
	}
	
	public String pop() {
		//implemented by win
		String deletedString=peek();
		list.remove(peek());
		return deletedString;
	}
	public String peek() {
		//implemented by win
		//System.out.println(list.size());
		//System.out.println(list.get(list.size()-1));
		return list.get(0);
	}
	
	public void push(String s) {
		//implemented by win
		list.add(s);
	}
	
	public static void main(String[] args) {
		MyStringStack stack = new MyStringStack(); 
		stack.push("Bob");
		System.out.println(stack.list.toString());
		stack.push("Harry");
		System.out.println(stack.list.toString());
		stack.push("Alice"); 
		System.out.println(stack.list.toString());
		System.out.println("Popping..."+stack.pop()); 
		System.out.println(stack.list.toString());
		System.out.println("Peeking...."+stack.peek()); 
		System.out.println("Popping..."+stack.pop());
		System.out.println(stack.list.toString());
	}
}