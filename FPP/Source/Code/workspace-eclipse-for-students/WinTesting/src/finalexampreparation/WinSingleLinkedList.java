package finalexampreparation;

import java.util.StringJoiner;

public class WinSingleLinkedList<E> {
	Node<E> first=null;
	Node<E> last=null;
	void addFirst(E data) {
		Node<E> newNode=new Node<E>(data, last);
		if(first==null)
			first=newNode;
		last=newNode;

	}


	@Override
	public String toString() {
		return first .toString();
	}


	static class Node<E>{
		E data;
		Node<E> next;

		Node(E data, Node<E> next){
			this.data=data;
			this.next=next;
		}

		@Override
		public String toString() {
			StringJoiner sj=new StringJoiner(", ", "[", "]");
			sj.add(data.toString());
			while(next!=null) {
				sj.add(next.data.toString());
				next=next.next;	
			}
			return sj.toString();
		}


	}
}
