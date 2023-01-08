package edu.mum.cs544.Repository;

import edu.mum.cs544.Domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @PersistenceContext
    private EntityManager em;

    public BookRepositoryImpl() {
    }

    @Override
    public List<Book> getAll() {
        return em.createQuery("from Book b", Book.class).getResultList();
    }

    @Override
    public void add(Book book) {
        em.persist(book);
    }

    @Override
    public Book get(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public void update(Book book) {
        em.merge(book);
    }

    @Override
    public void delete(int bookId) {
        Book book = em.getReference(Book.class, bookId);
        em.remove(book);
    }

}
