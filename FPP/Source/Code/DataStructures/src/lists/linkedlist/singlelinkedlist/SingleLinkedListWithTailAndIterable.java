package lists.linkedlist.singlelinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class SingleLinkedListWithTailAndIterable<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	
	public SingleLinkedListWithTailAndIterable() {
		this.head = this.tail = null; // 
	}
	
	public static void main(String[] args) {
		var list = new SingleLinkedListWithTailAndIterable<Integer>();
		System.out.println(list);
		list.add(1);
		System.out.println(list);
		list.add(2);
		list.add(3);
		System.out.println(list);
		list.forEach(n -> System.out.println(n));
	}
	
	public void addFirst(E e) {
		if(head == null) {
			head = tail = new Node<>(e);
		} else {
			Node<E> newHead = new Node<>(e, head);
			head = newHead;
		}
	}
	
	public void add(E e) { //i.e. addLast(..)
		Node<E> newNode = new Node<>(e);
		if(head == null) {				
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SingleLinkedListIterator<>();
	}
	
	private class SingleLinkedListIterator<E> implements Iterator<E> {
		private Node<E> next;
		
		private SingleLinkedListIterator() {
			this.next = (Node<E>) head;
		}

		@Override
		public boolean hasNext() {
			return (next != null);
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException("Error: There is no next element");
			E nextData = next.data;
			next = next.next;
			return nextData;
		}	
	}
	
	@Override
	public String toString() {
		// Using java.util.StringJoiner
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		Node<E> curr = head;
		while(curr != null) {
			sj.add(curr.data.toString());
			curr = curr.next;
		}
		return sj.toString();
		
//		StringBuilder sb = new StringBuilder();
//		sb.append("[");
//		Node<E> curr = head;
//		while(curr != null) {
//			sb.append(curr.data.toString() + " ");
//			curr = curr.next;
//		}
//		sb.append("]");
//		return sb.toString();
	}
	
	//TODO Implement more operations
	// get(int i)
	// insertAt(E e, int i)
	// addFirst -- done!!!
	// remove
	// search - linearSearch, O(n)
	// size() - // requires iterating, O(n)
	// etc.
	
	/**
	 * This class represents a Node for a SingleLinkedList
	 * @author obi
	 * @param <E>
	 */
	static class Node<E> {
		private E data;
		private Node<E> next;
		
		private Node() { }
		
		private Node(E e) {
			this.data = e;
		}
		
		private Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}	

}
