package lesson8testing.list.linkedlist.singlelinkedlist;

import java.util.StringJoiner;

public class MySingleLinkedList<E> {
	private Node<E> head;

	MySingleLinkedList(){
		this.head=null;
	} 

	public void add(E e) { //addLast - adding e to the end
		Node<E> newNode=new Node<>(e);
		//newNode.data=e; //as there is one constructor where accepts data
		if(head==null)//empty list
			head=newNode;
		else {
			Node<E> curr=head;
			while(curr.next!=null) { //O(n) using tail to improve to O(1)
				curr=curr.next;
			}
			curr.next=newNode;
		}
	}


	public void addFirst(E e) { //adding e to the first
		Node<E> newNode=new Node<>(e);
		if(head==null)
			head=newNode;
		else {
			newNode.next=head;
			head=newNode;
		}
		/*if(head==null)
			head=new Node<>(e);
		else {
			Node<E> newNode=new Node(e,head);
			head=newNode;
		}*/
	}

	@Override
	public String toString() {//[], [1], [1,2] etc
		StringJoiner sj=new StringJoiner(", ","[","]");
		Node<E> curr=head;
		while(curr!=null) {
			sj.add(curr.toString());
			curr=curr.next;
		}
		return sj.toString();
	}

	private static class Node<E>{
		private E data;
		private Node<E> next;

		private Node() {}
		private Node(E e) {
			this.data=e;
		}
		private Node(E data, Node<E> next) {
			this.data=data;
			this.next=next;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}
}
