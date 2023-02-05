package lists.linkedlist.singlelinkedlist;

import java.util.StringJoiner;

public class SingleLinkedList<E> {
	private Node<E> head;
	
	public SingleLinkedList() {
		this.head = null;
	}
	
	public void addFirst(E e) {
		if(head == null) {
			head = new Node<>(e);
		} else {
			Node<E> temp = new Node<>(e, head);
			head = temp;
		}
	}
	
	public void add(E e) { // addLast(..)
		Node<E> newNode = new Node<>(e);
		//newNode.data = e;
		if(head == null) {				
			head = newNode;
		} else {
			Node<E> curr = head;
			while(curr.next != null) { // O(n)
				curr = curr.next;
			}
			curr.next = newNode;
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
	// addFirst
	// remove
	// search - linearSearch, O(n)
	// etc.
	
	private static class Node<E> {
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
