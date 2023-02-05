package list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class SinglyListWithSentinel<E> implements Iterable<E> {
	Node<E> header;

	public SinglyListWithSentinel(){
		header=new Node<E>(null, null);
	}

	void addFirst(E e) {
		if(header.next==null)
			header.next=new Node<E>(e, null);
		else 
			header.next=new Node<E>(e, header.next);
	}

	public String toString() {
		return header.next.toString();
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

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>();
	}

	private class MyIterator<E> implements Iterator<E>{
		private Node<E> current;

		private MyIterator() {
			//current = header.next;
		}

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E nextData = current.data;
			current = current.next;
			return nextData;
		}
	}
}