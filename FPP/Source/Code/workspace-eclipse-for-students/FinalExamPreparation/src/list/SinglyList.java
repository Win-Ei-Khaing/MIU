package list;

import java.util.StringJoiner;

public class SinglyList<E> {
	Node<E> head;

	public SinglyList(){
		head=null;
	}

	void addFirst(E e) {
		if(head==null)
			head=new Node<E>(e, null);
		else 
			head=new Node<E>(e, head);
	}

	public String toString() {
		return head.toString();
	}
	
	private static class Node<E>{
		E data;
		Node<E> next;

		public Node(E data, Node<E> next){
			this.data=data;
			this.next=next;
		}

		public String toString() {
			StringJoiner sj=new StringJoiner(", ","[","]");
			sj.add(data.toString());
			while(next!=null) {
				sj.add(next.data.toString());
				next=next.next;
			}
			return sj.toString();
		}
	}
}
