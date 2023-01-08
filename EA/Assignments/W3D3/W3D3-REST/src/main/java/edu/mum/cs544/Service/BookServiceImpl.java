package edu.mum.cs544.Service;

import edu.mum.cs544.Domain.Book;
import edu.mum.cs544.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Resource
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
       bookRepository.save(book);
        
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void update(Book book) {
       bookRepository.save(book);
        
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    
}
