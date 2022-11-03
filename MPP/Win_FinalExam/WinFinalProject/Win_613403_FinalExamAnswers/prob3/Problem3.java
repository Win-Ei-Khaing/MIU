package prob3;

import helperclasses.Book;
import helperclasses.LibraryMember;
import helperclasses.TestData;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

//implemented by Win

public class Problem3 {
	public static void main(String[] args) {
		Problem3 p = new Problem3();
		List<LibraryMember> participants = TestData.INSTANCE.getMembers();
		p.specialBooks = TestData.INSTANCE.getAllBooks().iterator();
		LibraryMember mem = p.detectIfWinnerDuringCheckout(participants);
		System.out.println("Winner: " + (mem == null ? "none" : mem.getFirstName()));		
		
	}
	Iterator<Book> specialBooks;
	
	public LibraryMember detectIfWinnerDuringCheckout(List<LibraryMember> mems)  {		
		//fix this
//		return mems.stream().filter(mem -> 
//		       mem.checkout(specialBooks.next().getNextAvailableCopy(), LocalDate.now(), LocalDate.of(2015, 9, 1))
//		          .getCheckoutRecordEntries().size() == 10)
//		    .findFirst().orElse(null);

		//fixed by Win
		//this is with simple try catch block
//		return mems.stream().filter(mem -> 
//	       {
//			try {
//				return mem.checkout(specialBooks.next().getNextAvailableCopy(), LocalDate.now(), LocalDate.of(2015, 9, 1))
//				      .getCheckoutRecordEntries().size() == 10;
//			} catch (LibrarySystemException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return false;
//			}
//		})
//	    .findFirst().orElse(null);
		
		//this is with interface
		return mems.stream()
				.filter(mem->FunctionWithException
							.unchecked((LibraryMember m)->m.checkout(specialBooks.next().getNextAvailableCopy(), LocalDate.now(), LocalDate.of(2015, 9, 1))
							.getCheckoutRecordEntries().size() == 10)
							.apply(mem))
				.findFirst().orElse(null);
		
		
	}
}
