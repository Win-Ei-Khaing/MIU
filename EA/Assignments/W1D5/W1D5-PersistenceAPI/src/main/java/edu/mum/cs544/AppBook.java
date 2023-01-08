package edu.mum.cs544;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppBook {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        //Open a EntityManager
        em.getTransaction().begin();

        //Create 3 books save them to the database
        Book book1 = new Book("Title 1", "ISBN 1", "Author 1", 1000.00, new Date());
        em.persist(book1);

        Book book2 = new Book("Title 2", "ISBN 2", "Author 2", 2000.00, new Date());
        em.persist(book2);

        Book book3 = new Book("Title 3", "ISBN 3", "Author 3", 3000.00, new Date());
        em.persist(book3);

        //Close the EntityManager
        em.getTransaction().commit();

        //---------------------------------------------------------------------------

        //Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();

        //Retrieve all books and output them to the console
        TypedQuery<Book> retrieveQuery1 = em.createQuery("from Book", Book.class);
        List<Book> bookList1 = retrieveQuery1.getResultList();
        for (Book book : bookList1) {
            System.out.println("title= " + book.getTitle() 
                                + ", isbn= "+ book.getISBN() 
                                + ", author= " + book.getAuthor()
                                + ", price= " + book.getPrice()
                                + ", date= " + book.getPublish_date());
        }

        //Close the EntityManager
        em.getTransaction().commit();

        //---------------------------------------------------------------------------
         
        //Open a EntityManager
         em = emf.createEntityManager();
         em.getTransaction().begin();

        //Retrieve all books from the database
        TypedQuery<Book> retrieveQuery2 = em.createQuery("from Book", Book.class);
        List<Book> bookList2 = retrieveQuery2.getResultList();
        
        //Change the title and price of one book
        Book bookToUpdate = bookList2.get(0); //take first book to update
        bookToUpdate.setTitle("Updated Title 1");

        System.out.println("done updating tile");
        bookToUpdate.setPrice(5000.00);
        System.out.println("done updating price");
    
        for (Book book : bookList2) {
            System.out.println("title= " + book.getTitle() 
                                + ", isbn= "+ book.getISBN() 
                                + ", author= " + book.getAuthor()
                                + ", price= " + book.getPrice()
                                + ", date= " + book.getPublish_date());
        }


        //Use em.remove() to delete a different book (not the one that was just updated)
        Book bookToDelete = bookList2.get(2); //take third book to delete
        em.remove(bookToDelete);

        
        //Close the EntityManager
        em.getTransaction().commit();

        //---------------------------------------------------------------------------

        //Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();

        //Retrieve all books and output them to the console
        TypedQuery<Book> retrieveQuery3 = em.createQuery("from Book", Book.class);
        List<Book> bookList3 = retrieveQuery3.getResultList();
        for (Book book : bookList3) {
            System.out.println("title= " + book.getTitle() 
                                + ", isbn= "+ book.getISBN() 
                                + ", author= " + book.getAuthor()
                                + ", price= " + book.getPrice()
                                + ", date= " + book.getPublish_date());
        }

        //Close the EntityManager
        em.getTransaction().commit();

        em.close();
    } 
}
