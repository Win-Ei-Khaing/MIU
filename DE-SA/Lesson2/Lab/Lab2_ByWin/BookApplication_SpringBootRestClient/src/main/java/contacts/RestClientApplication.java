package contacts;

import books.Book;
import books.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*String serverUrl = "http://localhost:8080/contacts";

		// add Frank
		restTemplate.postForLocation(serverUrl, new Contact("Frank","Browns", "fbrowns@acme.com",
				"0639332163"));
		// add John
		restTemplate.postForLocation(serverUrl, new Contact("John","Doe", "jdoe@acme.com",
				"6739127563"));
		// get frank
		Contact contact= restTemplate.getForObject(serverUrl+"/{firstName}", Contact.class, "Frank");
		System.out.println("----------- get John-----------------------");
		System.out.println(contact.getFirstName()+" "+contact.getLastName());
        // get all
		Contacts contacts= restTemplate.getForObject(serverUrl, Contacts.class);
		System.out.println("----------- get all contacts-----------------------");
		System.out.println(contacts);

		// delete John
		restTemplate.delete(serverUrl+"/{firstName}", "John");

		// update frank
		contact.setEmail("franky@gmail.com");
		restTemplate.put(serverUrl+"/{firstName}", contact, contact.getFirstName());

		// get all
		contacts= restTemplate.getForObject(serverUrl, Contacts.class);
		System.out.println("----------- get all contacts-----------------------");
		System.out.println(contacts);*/

		String serverUrl = "http://localhost:8080/books";

		// add Book 1
		restTemplate.postForLocation(serverUrl, new Book("978-0-306-40615-11","Win", "About Myanmar",
				1000.00));
		// add Book 2
		restTemplate.postForLocation(serverUrl, new Book("978-0-306-40615-22","Ei", "Way back Burma",
				2000.00));

		// get Book 1
		Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "978-0-306-40615-11");
		System.out.println("----------- get Book 1 - About Myanmar-----------------------");
		System.out.println(book.getIsbn()+" "+book.getAuthor()+" "+book.getTitle()+" "+ book.getPrice());

		// get all
		Books books= restTemplate.getForObject(serverUrl, Books.class);
		System.out.println("----------- get all books-----------------------");
		System.out.println(books);

		// update Book 1
		book.setAuthor("Khaing");
		restTemplate.put(serverUrl+"/{isbn}", book, book.getIsbn());

		// get Book 1
		System.out.println("----------- get back Book 1 - About Myanmar-----------------------");
		System.out.println(book.getIsbn()+" "+book.getAuthor()+" "+book.getTitle()+" "+ book.getPrice());

		// delete Book 1
		restTemplate.delete(serverUrl+"/{isbn}", "978-0-306-40615-11");

		// get all
		books= restTemplate.getForObject(serverUrl, Books.class);
		System.out.println("----------- get all books-----------------------");
		System.out.println(books);
	}


	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
