package Final.prob1.exam;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Main {

	
	//Query A (for Problem 1A) given a member's checkout record, determine whether some
	//bookcopy in the record is overdue (a bookcopy is overdue if it is not available
	//and its due date is before now.
	public static boolean someBookOverdue(CheckoutRecord record) {
//	return record.getCheckoutEntries()
//				.stream()
//				.filter(e->(!e.getCopy().isAvailable()))
//				.filter(e->(Date.valueOf(e.getDueDate()).before(Calendar.getInstance().getTime())))
//				.count()>0;
          //return LambdaLibrary.OVERDUEBOOK.test(record); //implement
		
		return LambdaLibrary.OVERDUEBOOK.test(record);
	}
	
	//Query B (for Problem 1B) Given a BookCopy copy and a LibraryMember mem,
	//return true if mem has ever checked out this copy
	//
	public static boolean everCheckedOutBy(LibraryMember mem, BookCopy copy) {
		return mem.getRecord().getCheckoutEntries().stream().filter(e->e.getCopy().equals(copy)).findAny().isPresent();
		
		//return LambdaLibrary.EVERCHECKEDOUT.test(mem, copy); //implement
	}
	
	//Query C (for Problem 1C) given a list of all library members, return a list, in
	//reverse sorted order (by first name), of the
	//full names of those library members who have never checked out a book
	public static List<String> nonActiveMembers(List<LibraryMember> list) {
		return list
				.stream()
				.filter(m->m.getRecord().getCheckoutEntries().size()==0)
				//.sorted((LibraryMember m1, LibraryMember m2)->m1.getFirstName().compareTo(m2.getLastName()))
				.sorted(Comparator.comparing(LibraryMember::getFirstName).reversed())
				.map(m->m.getFirstName()+" "+m.getLastName())
				.collect(Collectors.toList());
		
		//return new ArrayList<String>();
	}
	
	
	

}
