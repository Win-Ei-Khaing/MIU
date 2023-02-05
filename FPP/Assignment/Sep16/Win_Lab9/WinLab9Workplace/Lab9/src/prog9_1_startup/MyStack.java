package prog9_1_startup;

public class MyStack {
	private MyStringLinkedList list;
	public MyStack() {
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
}
