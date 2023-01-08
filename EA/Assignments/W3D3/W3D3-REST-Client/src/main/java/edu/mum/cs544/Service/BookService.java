package edu.mum.cs544.Service;

import edu.mum.cs544.Domain.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Integer add(Book book);

    public Book findById(int id);

    public void update(Book book);

    public void delete(int id);

}
