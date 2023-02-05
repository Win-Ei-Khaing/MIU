package finalexampreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CommonSingleLinkedListWithSentinel<E> {
	Node<E> header;

	CommonSingleLinkedListWithSentinel(){
		header=new Node<E>(null, null);
	}

	void addFirst(E data) {
		Node<E> newNode=new Node<E>(data, header);
		header.next=newNode;
	}


	@Override
	public String toString() {
		return header.next.toString();
	}

	void printAllInReverse( ) {
		Node<E> current = header.next; 
		Node<E> next = null, previous = null; 
		while (current != null) { 
			next = current.next; 
			current.next = previous;  

			previous = current;
			current = next;
		}
		
			System.out.println(previous.toString());
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
