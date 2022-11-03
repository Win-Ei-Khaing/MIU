package Final.prob1.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestCode {
	//private static Consumer<CheckoutRecord> c= (CheckoutRecord record) -> System.out.println(record.getCheckoutEntries());;
	private static Function<CheckoutRecord,List<CheckoutRecordEntry>> s= (CheckoutRecord record) -> record.getCheckoutEntries();
	
	private static Function<CheckoutRecord,List<CheckoutRecordEntry>> s1= CheckoutRecord::getCheckoutEntries;
	
	public static class InnS implements Function<CheckoutRecord,List<CheckoutRecordEntry>>{

		@Override
		public List<CheckoutRecordEntry> apply(CheckoutRecord t) {
			// TODO Auto-generated method stub
			return t.getCheckoutEntries();
		}
		
	}
///////// Testing -- do not modify this code!! ////////////
public static void main(String[] args) {
	testSomeBookOverdue();
	testEverCheckedOutBy(); 
	testNonactiveMembers();
	
	System.out.println("\nTesting by win\n");
	//c.accept(TestData.INSTANCE.getAllRecords().get(0));
	
	System.out.println("\n");
	System.out.println(s.apply(TestData.INSTANCE.getAllRecords().get(0)));
	
	System.out.println("\n");
	System.out.println(s1.apply(TestData.INSTANCE.getAllRecords().get(0)));
	
	System.out.println((new InnS()).apply(TestData.INSTANCE.getAllRecords().get(0)));
}

public static void testSomeBookOverdue() {
	List<CheckoutRecord> list = TestData.INSTANCE.getAllRecords();
	List<Boolean> results = new ArrayList<>();
	for(CheckoutRecord rec : list) {
		System.out.println(rec);
		System.out.println("_____________________");
		results.add(Main.someBookOverdue(rec));
		
	}
	System.out.println("Test some book overdue results: " + 
	   (results.isEmpty() ? "Not attempted" : results.toString()));
	
	System.out.println("_____________________");
}
public static void testEverCheckedOutBy() {
	List<LibraryMember> members = TestData.INSTANCE.getMembers();
	List<Book> books = TestData.INSTANCE.getAllBooks();
	List<Boolean> results = new ArrayList<>();
	for(LibraryMember mem : members) {
		for(Book b : books) {
			for(BookCopy copy : b.getCopies()) {
				results.add(Main.everCheckedOutBy(mem, copy));
			}
		}
	}
	System.out.println("Check each member and each book copy to see if checked out:\n " + results);
	System.out.println("_____________________");
}
public static void testNonactiveMembers() {
	List<LibraryMember> members = TestData.INSTANCE.getMembers();
	System.out.println(members);
	
	System.out.println("Test nonactive members: " + Main.nonActiveMembers(members)); 
}
}