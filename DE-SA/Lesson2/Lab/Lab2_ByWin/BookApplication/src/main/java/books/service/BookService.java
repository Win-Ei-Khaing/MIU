package books.service;

import books.data.BookRepository;
import books.domain.Book;
import books.integration.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    JmsSender jmsSender;
    public void addBook(Book book){
        bookRepository.save(book);
        jmsSender.sendMessage(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
        jmsSender.sendMessage(book);
    }

    public void deleteBook(String isbn){
        jmsSender.sendMessage(this.getBook(isbn));
        bookRepository.delete(isbn);
    }

    public Book getBook(String isbn){
        return bookRepository.getBook(isbn);
    }

    public Collection<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
}
