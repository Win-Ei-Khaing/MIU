package edu.mum.cs544.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.mum.cs544.Domain.Book;
import edu.mum.cs544.Service.BookService;

@Component
public class Client implements CommandLineRunner { 

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) {
        System.out.println("Finding all books...");
        System.out.println(bookService.findAll()); 
        System.out.println("-----------");

        System.out.println("Adding books...");
        Book book1 = new Book("About Summer","978-0-306-40615-7", "Susan", 20000.00);
        Integer book1Id = bookService.add(book1); 
        Book book2 = new Book("About Winter","978-0-306-40615-7", "Welda", 30000.00);
        bookService.add(book2); 

        System.out.println("Finding all books agin...");
        System.out.println(bookService.findAll()); 
        System.out.println("-----------");

        System.out.println("Updating book 1....");
        book1.setId(book1Id);
        book1.setAuthor("Updated Susan");
        bookService.update(book1); 

        System.out.println("Finding all books agin...");
        System.out.println(bookService.findAll()); 
        System.out.println("-----------");

        System.out.println("Finding a book by book 1 ID...");
        Book b = bookService.findById(book1Id); 
        if(b != null) {
            System.out.println(b.toString());
            System.out.println("-----------");

            System.out.println("Deleting this book...");
            bookService.delete(book1Id); 
        }
        else
            System.out.println("No Book with id 1");
        System.out.println("-----------");

        System.out.println("Finding all books agin...");
        System.out.println(bookService.findAll()); 
        System.out.println("-----------");
} }