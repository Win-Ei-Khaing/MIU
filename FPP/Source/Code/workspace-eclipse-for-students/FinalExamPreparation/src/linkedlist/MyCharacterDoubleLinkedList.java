package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyCharacterDoubleLinkedList implements Iterable<Character>{
	private Node head;
	private Node tail;

	void addFirst(Character c) {
		if(head==null && tail==null)
			head=tail=new Node(c, null, null);
		else {
			Node newNode=new Node(c, head, null);
			if(head!=null)
				head.previous=newNode;
			head=newNode;
		}
	}

	boolean contains(Character c) {
		Node currNode=head;
		while(currNode!=null) {
			if(currNode.data.equals(c))
				return true;
			currNode=currNode.next;
		}
		return false;
	}

	public String toString() {
		StringJoiner sj=new StringJoiner(", ", "[", "]");
		Node currNode=head;
		while(currNode!=null) {
			sj.add(currNode.data.toString());
			currNode=currNode.next;
		}
		return sj.toString();
	}

	public void printAllInReverse() {
		StringJoiner sj=new StringJoiner(", ", "[", "]");
		Node currNode=tail;
		while(currNode!=null) {
			sj.add(currNode.data.toString());
			currNode=currNode.previous;
		}
		System.out.println(sj.toString()); 
	}
	private static class Node{
		private Character data;
		private Node next;
		private Node previous;

		Node(Character data, Node next, Node previous){
			this.data=data;
			this.next=next;
			this.previous=previous;
		}
	}
	@Override
	public Iterator<Character> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Character>{
		Node currNode;
		MyIterator(){
			currNode=head;
		}

		@Override
		public boolean hasNext() {
			return currNode!=null;
		}

		@Override
		public Character next() {
			if(!hasNext())
				throw new NoSuchElementException();
			Character nextData=currNode.data;
			currNode=currNode.next;
			return nextData;
		}
	}
}