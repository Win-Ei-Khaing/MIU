package lesson9.labs.prob1.business;

import java.util.*;
import java.util.stream.Collectors;
import lesson9.labs.prob1.dataaccess.DataAccess;
import lesson9.labs.prob1.dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {
		System.out.println("allWhoseZipContains3() : "+allWhoseZipContains3());
		System.out.println("\n");
		System.out.println("allHavingAtLeastTwoCopies() : "+allHavingAtLeastTwoCopies());
		System.out.println("\n");
		System.out.println("allHavingMultipleAuthors() : "+allHavingMultipleAuthors());
	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		mems.stream().forEach(System.out::println);
		//implemented by win
		/*List<String> result = mems.stream()
				.filter(m->(m.getAddress().getZip().contains("3")))
				.map(m->m.getMemberId())
				.collect(Collectors.toList());*/
		List<String> result = da.readMemberMap().values()
				.stream()
				.filter(m->m.getAddress().getZip().contains("3"))
				.map(m->m.getMemberId())
				.collect(Collectors.toList());
		
		return result;
		
	}
	//Returns a list of all isbns of books having at least two copies
	public static List<String> allHavingAtLeastTwoCopies() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		bs.forEach(System.out::println);
		//implemented by win
		/*List<String> result = bs.stream()
				.filter(m->m.getCopies().length >= 2)
				.map(m->m.getIsbn())
				.collect(Collectors.toList());*/
		
		List<String> result = da.readBooksMap().values()
				.stream()
				.filter(b->b.getCopies().length>=2)
				.map(b->b.getIsbn())
				.collect(Collectors.toList());
		return result;
		
	}

	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		//implemented by win
//		List<String> result = bs.stream()
//				.filter(m->m.getAuthors().size()>1)
//				.map(m->m.getIsbn())
//				.collect(Collectors.toList());
		
		List<String> result = da.readBooksMap().values()
				.stream()
				.filter(b->b.getAuthors().size()>1)
				.map(b->b.getIsbn())
				.collect(Collectors.toList());
		return result;
		
		}

}
