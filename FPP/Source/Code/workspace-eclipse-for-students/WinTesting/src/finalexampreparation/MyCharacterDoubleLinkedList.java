package finalexampreparation;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyCharacterDoubleLinkedList  implements Iterable<Character>{
	Node header;

	MyCharacterDoubleLinkedList(){
		header=new Node(null, null, null);
	}

	void addFirst (Character c) {
		Node newNode = new Node(c, header.next, header);
		if(header.next!=null) {
			header.next.previous=newNode;
		}
		header.next=newNode;
	} 
	boolean contains (Character c) {
		Node currNode=header.next;
		while(currNode!=null) {
			if(currNode.data==c)
				return true;
			currNode=currNode.next;
		}
		return false;
	}
	@Override
	public String toString() {
		StringJoiner sj=new StringJoiner(", ","[","]");
		Node currNode=header.next;
		while(currNode!=null) {
			sj.add(currNode.data.toString());
			currNode=currNode.next;
		}
		return sj.toString();
		/*StringBuffer sb=new StringBuffer();
		sb.append("[");
		Node currNode=header.next;
		while(currNode!=null) {
			sb.append(currNode.data + ", ");
			currNode=currNode.next;
		}
		sb.append("]");
		String result=sb.toString();
		if(result.length()>2 && result.charAt(result.length()-3) == ',')
			return result.substring(0, result.length()-3).toString()+"]";
		return result;*/
	}
	void printAllInReverse( ) {
		Node last=header.next;
		while(last.next!=null)
			last=last.next;
		StringJoiner sj=new StringJoiner(", ","[","]");
		while(last!=header) {
			sj.add(last.data.toString());
			last=last.previous;
		}
		System.out.println(sj.toString());
	}
	class Node{
		Character data;
		Node next;
		Node previous;
		public Node(Character data, Node next, Node previous) {
			super();
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

	}
	@Override
	public Iterator<Character> iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<Character> {
		private Node nextNode;

		private MyIterator() {
			nextNode = header.next;
		}

		@Override
		public boolean hasNext() {
			return (nextNode != null);
		}

		@Override
		public Character next() {
			if(!hasNext())
				throw new NoSuchElementException();
			Character nextData = nextNode.data;
			nextNode = nextNode.next;
			return nextData;
		}
	}
}
