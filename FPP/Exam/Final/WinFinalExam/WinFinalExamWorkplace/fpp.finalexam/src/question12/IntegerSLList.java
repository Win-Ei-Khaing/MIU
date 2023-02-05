package question12;

import java.util.StringJoiner;

/**
 * A singly-linkedlist for Integers.
 * 
 * @author O. Kalu
 * @since 
 */
public class IntegerSLList {
	private Node head;

	// IMPLEMENTED BY WIN

	/**
	 * Adds the new Integer element, i, 
	 * to the end of the list 
	 * @param i
	 */
	public void addLast(Integer i) {
		//TODO 1: (5 points)
		Node newNode = new Node(i, null);
		if(head == null)
			head = newNode;
		else {
			Node currNode = head;
			while(currNode.next != null) {
				currNode=currNode.next;
			}
			currNode.next=new Node(i, null);
		}
	}	

	/**
	 * Removes the first element from the list
	 * and returns its value. If the list does not
	 * contain any element, this returns null 
	 * @return
	 */
	public Integer removeFirst() {
		//TODO 2: (5 points)
		if(head == null)
			return null;
		else {
			Integer numToDelete = head.data;
			head = head.next;
			return numToDelete;
		}
	}

	/**
	 * Returns the value of the element
	 * in the list whose value is the largest.
	 * If the list is empty, returns null.
	 * @return the largest
	 */
	public Integer findMax() {
		// TODO 3: (5 points)
		//no head case
		if(head == null)
			return null;
		//only head case
		if(head.next == null)
			return head.data;

		//multiple data case
		Integer largest=head.data;
		Node currNode=head.next;
		while(currNode != null) {
			if(largest < currNode.data)
				largest = currNode.data;
			currNode = currNode.next;
		}
		return largest;
	}

	/**
	 * Prints out all the elements in the list
	 * in the format, [1=>2=>3=>4]
	 */
	public void printAll() {
		//5: TO DO (5 points)
		StringJoiner sj=new StringJoiner("=>", "[", "]");
		Node currNode=head;
		while(currNode != null) {
			sj.add(currNode.data.toString());
			currNode=currNode.next;
		}
		System.out.println(sj.toString());
	}

	private static class Node{
		Integer data;
		Node next;

		Node(Integer data, Node next){
			this.data=data;
			this.next=next;
		}
	}
}
