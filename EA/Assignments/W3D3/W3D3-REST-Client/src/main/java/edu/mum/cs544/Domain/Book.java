package edu.mum.cs544.Domain;

public class Book {
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    public Book() {
    }
    public Book(String title, String iSBN, String author, double price) {
        this.title = title;
        ISBN = iSBN;
        this.author = author;
        this.price = price;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
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
    @Override
    public String toString() {
        return "Book [ISBN=" + ISBN + ", author=" + author + ", id=" + id + ", price=" + price + ", title=" + title
                + "]";
    }
}
