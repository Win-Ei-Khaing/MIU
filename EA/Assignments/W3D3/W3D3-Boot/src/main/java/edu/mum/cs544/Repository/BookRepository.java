package edu.mum.cs544.Repository;

import edu.mum.cs544.Domain.Book;

import java.util.List;

public interface BookRepository {

    public List<Book> getAll();

    public void add(Book book);

    public Book get(int id);

    public void update(Book book);

    public void delete(int bookId);

}
