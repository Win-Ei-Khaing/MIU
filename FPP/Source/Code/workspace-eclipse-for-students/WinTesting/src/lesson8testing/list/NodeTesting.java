package lesson8testing.list;

public class NodeTesting {
	public static void main(String[] args) {
		Node startNode=new Node();
		startNode.data="A";
		//System.out.println(startNode);

		Node nextNode=new Node();
		nextNode.data="B";
		startNode.next=nextNode;

		Node nextNode2=new Node();
		nextNode2.data="C";
		nextNode.next=nextNode2;

		//System.out.println();

		//printing session
		Node currentNode=startNode;
		StringBuilder sb=new StringBuilder();
		for(;currentNode!=null;) {
			sb.append(currentNode.data+" ");
			currentNode=currentNode.next;
		}
		System.out.println(sb.toString());
	}
}
