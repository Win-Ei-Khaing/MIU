package edu.mum.cs544.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.mum.cs544.Domain.Book;
import edu.mum.cs544.Service.BookService;

@RestController
public class BookRestController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public RedirectView redirectRoot() {
        return new RedirectView("/books");
    }

    @GetMapping(value="/books")
    public List<Book> getAll() {
        return bookService.findAll();
    }
       
    @GetMapping(value= "/books/{id}")
    public Book get(@PathVariable int id) {
        return bookService.findById(id);
    }
    
    @PostMapping(value="/books")
    public RedirectView add(@RequestBody @Valid Book book, BindingResult result) {
        if(!result.hasErrors())
            bookService.add(book);
        return new RedirectView("/books/" + book.getId());
    }

    @PutMapping(value= "/books/{id}")
    public void update(@PathVariable int id, @RequestBody Book book) {
        if (book!=null) 
        {
            if(id != book.getId())
                throw new IllegalArgumentException(); 
        }
            bookService.update(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}
