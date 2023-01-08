package edu.mum.cs544.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.ISBN;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String title;
    @ISBN
    private String ISBN;
    @NotBlank
    private String author;
    @Positive
    private double price;
    
    // @Past
    // private LocalDate publishedDate;

    public Book(){  }

    public Book(String title, String ISBN, String author, double price) {
        super();
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
    }

    //for Optional Additional Exercise:
    // public Book(@NotBlank String title, @org.hibernate.validator.constraints.ISBN String iSBN, @NotBlank String author,
    //         @Positive double price, LocalDate publishedDate) {
    //     this.title = title;
    //     ISBN = iSBN;
    //     this.author = author;
    //     this.price = price;
    //     this.publishedDate = publishedDate;
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){ this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // public LocalDate getPublishedDate() {
    //     return publishedDate;
    // }

    // public void setPublishedDate(LocalDate publishedDate) {
    //     this.publishedDate = publishedDate;
    // }

}
