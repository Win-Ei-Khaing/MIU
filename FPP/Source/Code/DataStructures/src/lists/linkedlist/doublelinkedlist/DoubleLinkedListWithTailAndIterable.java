package lists.linkedlist.doublelinkedlist; // NOT using Sentinel

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class DoubleLinkedListWithTailAndIterable<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
		
	public DoubleLinkedListWithTailAndIterable() {
		super();
		head = tail = null;
		// head = null;
		// tail = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * Adds a new element, e, to the end of the list
	 * @param e
	 */
	public void add(E e) { // addLast
		Node<E> newNode = new Node<>(e);
		if(size == 0) { // if(head == null) {
			head = tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = tail.next; // tail = newNode;		
		}
		size++;
	}
	
	/**
	 * Returns the element at the position, index, from the list
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	public E get(int index) {
		if(!isValidIndex(index))
			throw new IndexOutOfBoundsException();
		Node<E> currNode = head; // can use a counter
		for(int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		return currNode.data;
	}
	
	private boolean isValidIndex(int index) {
		return (index >= 0 && index < size);
	}
	
    /**
     * Prints-out all the elements in the list,
     * in the format, [e1 <==> e2 <==> e3].
     */
	public void printAll() {
		StringJoiner sj = new StringJoiner("<==>", "[", "]");
		Node<E> currNode = head;
		for(int i = 0; i < size; i++) {
			sj.add(currNode.data.toString());
			currNode = currNode.next;
		}
		System.out.println(sj.toString());
	}
	
    /**
     * Return a string representation of all the elements in the list,
     * in the format, [e1 <==> e2 <==> e3].
     */
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("<==>", "[", "]");
		Node<E> currNode = head;
		for(int i = 0; i < size; i++) {
			sj.add(currNode.data.toString());
			currNode = currNode.next;
		}
		return sj.toString();
	}
	
    /**
     * Prints-out all the elements in the list,
     * in reverse, and in the format, [e3 <==> e2 <==> e1].
     */
	public void printAllInReverse() {
		StringJoiner sj = new StringJoiner("<==>", "[", "]");
		Node<E> currNode = tail;
		for(int i = 0; i < size; i++) {
			sj.add(currNode.data.toString());
			currNode = currNode.prev;
		}
		System.out.println(sj.toString());
	}

	@Override
	public Iterator<E> iterator() {
		return new DoubleLinkedListIterator<>();
	}
	
	private class DoubleLinkedListIterator<E> implements Iterator<E> {
		private Node<E> nextNode;
		
		private DoubleLinkedListIterator() {
			nextNode = (Node<E>)head;
		}

		@Override
		public boolean hasNext() {
			return (nextNode != null);
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E nextData = nextNode.data;
			nextNode = nextNode.next;
			return nextData;
		}
	}
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		private Node(E data, Node<E> next, Node<E> prev) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		private Node(E data) {
			this(data, null, null);
		}

		private Node(E data, Node<E> next) {
			this(data, next, null);
		}						
	}

}
