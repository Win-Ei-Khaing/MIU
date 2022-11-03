package lesson9.labs.prob9;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Set Up
		Book book = new Book("test", 3);
		List<BookCopy>  copies= book.getCopies();
		copies.forEach(copy->copy.changeAvailability());
		//copies.get(0).changeAvailability();
		
		//Test
		System.out.println(book.isAvailable());
	}

}
