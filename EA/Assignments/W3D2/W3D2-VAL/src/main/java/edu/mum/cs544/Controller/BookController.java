package edu.mum.cs544.Controller;

import edu.mum.cs544.Domain.Book;
import edu.mum.cs544.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }

    @GetMapping("/books/add")
    public String viewAdd(Model model) {
        if (!model.containsAttribute("book")) {
            model.addAttribute("book", new Book());
        }
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @PostMapping("/books")
    public String add(@Valid Book book, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) { 
            attr.addFlashAttribute("org.springframework.validation.BindingResult.book", result); 
            attr.addFlashAttribute("book", book);
            return "redirect:/books/add";
        } 
        else {
            bookService.add(book);
            return "redirect:/books";
        }   
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model) {
        if (!model.containsAttribute("book")) {
            model.addAttribute("book", bookService.get(id));
        }
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(@PathVariable int id, @Valid Book book, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) { 
            attr.addFlashAttribute("org.springframework.validation.BindingResult.book", result); 
            attr.addFlashAttribute("book", book);
            return "redirect:/books/{id}";
        }
        else {
            bookService.update(book);
            return "redirect:/books";
        }   
    }

    @PostMapping(value="/books/delete")
    public String delete(int id) {
        bookService.delete(id);
        return "redirect:/books";
    }

}
