package finalexampreparation;

public class CommonMain {

	public static void main(String[] args) {
		/*CommonSingleLinkedList<Character> csl=new CommonSingleLinkedList<Character>();
		csl.addFirst('A');
		csl.addFirst('B');
		csl.addFirst('C');
		csl.addFirst('D');
		System.out.println(csl.toString());*/
		
		CommonSingleLinkedListWithSentinel<Character> cslWithSentinel=new CommonSingleLinkedListWithSentinel<Character>();
		cslWithSentinel.addFirst('A');
		cslWithSentinel.addFirst('B');
		cslWithSentinel.addFirst('C');
		cslWithSentinel.addFirst('D');
		System.out.println(cslWithSentinel.toString());
		cslWithSentinel.printAllInReverse();
	}

}
