package edu.mum.cs544.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.Domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    public Book findById(int id);
}
