package lists.linkedlist.singlelinkedlist;

import java.util.StringJoiner;

public class SingleLinkedListWithTail<E> {
	private Node<E> head;
	private Node<E> tail;
	
	public SingleLinkedListWithTail() {
		this.head = this.tail = null; // 
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
