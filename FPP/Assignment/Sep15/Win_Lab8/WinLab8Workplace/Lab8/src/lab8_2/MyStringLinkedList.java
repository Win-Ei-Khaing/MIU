package lab8_2;

public class MyStringLinkedList {
	Node header;
	MyStringLinkedList(){
		header = new Node(null,null, null);
	}
	public void addFirst(String item){
		Node n = new Node(header.next,header,item);
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;

	}
	void printNodes() {
		Node next = header.next;
		if(next == null) System.out.println("");
		else {
			String s= next.toString();
			System.out.println(s);
		}
	}
	class Node {
		String value;
		Node next;
		Node previous;
		Node(Node next, Node previous, String value){
			this.next = next;
			this.previous = previous;
			this.value = value;
		}
		@Override
		public String toString() {
			if(value == null) return "";
			StringBuilder sb = new StringBuilder(value + " ");
			sb = toString(sb, next);
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;
			sb.append(n.value + " ");
			return toString(sb, n.next);
		}


	}

	//implementations for exercise 
	//inserts a new Node containing data so that its
	//position in the list is now pos
	void insert(String data, int pos)
	{
		//if pos is less than 1, we don't have to go on
		if(pos < 1) return;
		//if pos is 1, it is like add first, we just need to adjust with header
		if(pos == 1) {
			Node newNode=new Node(header.next, header, data);
			if(header.next!=null)
				header.next.previous=newNode;
			header.next=newNode;
		}
		//we need to adjust with other if pos is greater than 1
		else {
			//finding position and add new node there
			Node temp = header;
			for(int i = 1; i < pos; i++) {
				if(temp != null) { //if pos is not out of bound
					temp = temp.next;
				}
			}

			if(temp==null) return; //pos out of bound
			else {
				Node newNode=new Node(temp.next,temp, data);
				if(temp.next!=null)
					temp.next.previous=newNode;
				temp.next=newNode;
			}
		}
	}

	//attempts to remove the first Node that contains 
	//data; if successful, returns true; otherwise, false. 
	boolean remove(String data) {
		if(header.next!=null) {
			//finding a node to remove which equals with data
			Node temp = header.next;
			while(temp!=null && !temp.value.equals(data)) { //temp node checked first for null, not to get value.equals null exception
				//if(temp.next!=null)
				temp = temp.next;
			}
			//if equal node is exist, let's remove from list
			if(temp!=null) {
				//if that node is the last one in the list
				if(temp.next!=null)
					temp.next.previous=temp.previous;
				temp.previous.next=temp.next;

				return true; //successfully removed
			}
		}
		return false; //not found
	}

	//recursively attempts to find a String in some Node in the 
	//list; returns true if found, false otherwise
	boolean recurSearch(String data) { //I made this API method and added helper method with two params
		if(header.next!=null) {
			return recurSearch(data, header.next);
		}
		else
			return false;
	}

	boolean recurSearch(String data, Node node) {
		if(node!=null && node.value!=null) { //node checked first for null, not to get node.value null exception
			if(node.value.equals(data)) return true;
			else return recurSearch(data, node.next);
		}
		else 
			return false;
	}


	public boolean binarySearch(String data) {
		return binarySearch(data, header, null);
	}


	boolean binarySearch(String data, Node startNode, Node endNode) { //for the first time, it will be header node
		if(startNode==null) return false;
		//we can mark size value 
		//get length of list
		Node curr=startNode;
		int count=0;
		boolean wantToStop=false;
		while(curr.next!=null && !wantToStop) {
			if(endNode!=null) {
				if(curr.value.equals(endNode.value)) //this is for recursive function
					wantToStop=true;
				curr=curr.next;
				count++;
			}

			//search middle one first by going to mid index
			int mid=0;
			Node midNode=new Node(null, null, null);
			while(mid<=(count/2)+1) { //+1 is because there will be header node (with null values)
				midNode.value=startNode.value;
				midNode.next=startNode.next;
				midNode.previous=startNode.previous;

				startNode=startNode.next;
				mid++;
			}

			//compare with middle value and desired search value 'data'
			if(data.equals(midNode.value)) return true; //if middle value and data equals, return true. we found that
			if(data.compareTo(midNode.value)>0) return binarySearch(data, midNode.next,null); //because midNode is needed to exclude according binary search logic
			else if(data.compareTo(midNode.value)<0) return binarySearch(data, startNode, midNode.previous);//because midNode is needed to exclude according binary search logic
		}

		return false;
	}

	//sort(), swap() and minpos() is only for sorting, the same with MinSort
	public void sort(){
		if(header.next== null) return;
		Node temp=header.next;
		while(temp.next!=null){
			Node minNode = minpos(temp);
			swap(temp,minNode); 
			temp=temp.next;
			//printNodes();
		}

	}

	void swap(Node n1, Node n2){
		String temp = n1.value;//as Node object can't work for swap
		n1.value = n2.value;
		n2.value = temp;
	}

	//find minimum node starding from curr node
	public Node minpos(Node curr){	
		Node min=curr;
		while(curr.next!=null) {
			//System.out.println(min.value+"_"+curr.next.value);
			if(min.value.compareTo(curr.next.value)>0)
				min=curr.next;
			curr=curr.next;
		}
		return min;
	}

	//main
	public static void main(String[] args) {
		MyStringLinkedList list = new MyStringLinkedList();
		list.addFirst("A");
		list.remove("E");
		list.addFirst("B");
		list.addFirst("C");
		list.addFirst("D");
		list.insert("E",2);
		list.printNodes();

		list.sort();
		System.out.println("After sorting : ");
		list.printNodes();

		System.out.println("Searching by binary search for C : " + list.binarySearch("C"));
		System.out.println("Searching by binary search for F : " + list.binarySearch("F"));

		System.out.println("Searching for E : "+list.recurSearch("E"));

		list.remove("E");
		list.printNodes();
		list.remove("C");
		list.printNodes();
		list.remove("D");
		list.printNodes();

		System.out.println("Searching for E : "+list.recurSearch("E"));
		//System.out.println(list.header.value);

		System.out.println("\nNew list 2 :");
		MyStringLinkedList list2 = new MyStringLinkedList();
		list2.insert("Win", 1);
		list2.insert("Ei", 2);
		list2.printNodes();
		System.out.println("Searching for Ei : "+list2.recurSearch("Ei"));
		list2.remove("Ei");
		System.out.println("Removed Ei");
		System.out.println("Searching for Ei : "+list2.recurSearch("Ei"));
		list2.printNodes();
		
		System.out.println("\nTest cases from question :");
		MyStringLinkedList l = new MyStringLinkedList();
		l.addFirst("big");
		l.addFirst("small");
		l.addFirst("tall");
		l.addFirst("short");
		l.addFirst("round");
		l.addFirst("square");
		l.addFirst("enormous");
		l.addFirst("tiny");
		l.addFirst("gargantuan");
		l.addFirst("lilliputian");
		l.addFirst("numberless");
		l.addFirst("none");
		l.addFirst("vast");
		l.addFirst("miniscule");
		l.printNodes();
		l.sort();
		System.out.println("\nAfter sorting using MinSort : ");
		l.printNodes();
		System.out.println("\nSearching \"number\" : "+l.binarySearch("number"));
		System.out.println("\nSearching \"tiny\" : "+l.binarySearch("tiny"));
	}

}


