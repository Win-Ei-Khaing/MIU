package lists.linkedlist.singlelinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class SingleLinkedListWithTailAndIterable2<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public SingleLinkedListWithTailAndIterable2() {
		super();
		this.head = this.tail = null;
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	/**
	 * Appends the specified element to the end of this list.
	 * @param e
	 */
	public void add(E e) {
		Node<E> newNode = new Node<>(e);
		if(size == 0) { // if(head == null) {
			this.head = this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		size++;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		Node<E> curr = head;
		while(curr != null) {
			sj.add(curr.data.toString());
			curr = curr.next;
		}
		return sj.toString();
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SingleLinkedListIterator<>();
	}
	
	/**
	 * An Iterator for this SingleLinkedList
	 * @author obi
	 * @param <E>
	 */
	private class SingleLinkedListIterator<E> implements Iterator<E> {
		private Node<E> next;
		
		private SingleLinkedListIterator() {
			this.next = (Node<E>)head;
		}

		@Override
		public boolean hasNext() {
			return (next != null);
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E nextData = next.data;
			next = next.next;
			return nextData;
		}		
	}

	public static void main(String[] args) {
		var list = new SingleLinkedListWithTailAndIterable2<Integer>();
		System.out.println(list);
		System.out.printf("size: %d\n", list.size());
		list.add(1);
		System.out.println(list);
		System.out.printf("size: %d\n", list.size());
		list.add(2); list.add(3); list.add(4);
		System.out.println(list);
		System.out.printf("size: %d\n", list.size());
		// Using the Iterator
		System.out.println("Using the Iterator:");
		System.out.print("Using for...loop with Iterator: ");
		for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		System.out.print("Using Enhanced for...loop: ");
		for(var n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		System.out.print("Using list.forEach(lambda-expression): ");
		list.forEach(n -> System.out.print(n + " "));
	}
	
	/**
	 * Node class for a SingleLinkedList
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next;
		
		private Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		private Node(E data) {
			this(data, null);
		}
		
		private Node() {
			this(null, null);
		}	
	}
}
