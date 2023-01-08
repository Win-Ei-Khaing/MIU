package edu.mum.cs544.Service;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs544.Domain.Book;

@Service
public class BookServiceProxy implements BookService{
    @Autowired
    private RestTemplate restTemplate;
    private final String bookUrl = "http://localhost:8080/books/{id}"; 
    private final String booksUrl = "http://localhost:8080/books/";

    @Override
    public List<Book> findAll() {
        ResponseEntity<List<Book>> response = restTemplate.exchange(booksUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>(){});
       return response.getBody();
    }

    @Override
    public Integer add(Book book) {
        URI uri = restTemplate.postForLocation(booksUrl, book);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/books/(\\d+)").matcher(uri.getPath()); m.matches();
        return Integer.parseInt(m.group(1));
    }

    @Override
    public Book findById(int id) {
        return restTemplate.getForObject(bookUrl, Book.class, id);
    }

    @Override
    public void update(Book book) {
        if(book != null)
            restTemplate.put(bookUrl, book, book.getId());
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(bookUrl, id);
    }
    
}
