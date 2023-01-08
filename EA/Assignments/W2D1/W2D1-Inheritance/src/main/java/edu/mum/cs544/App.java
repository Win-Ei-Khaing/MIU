package edu.mum.cs544;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.mum.cs544.Domain.Book;
import edu.mum.cs544.Domain.CD;
import edu.mum.cs544.Domain.Customer;
import edu.mum.cs544.Domain.DVD;
import edu.mum.cs544.Domain.Order;
import edu.mum.cs544.Domain.OrderLine;
import edu.mum.cs544.Domain.Product;

//This class is for Exercise IMP.1 – Mapping Inheritance by Group12.
public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
                
        EntityManager em = emf.createEntityManager();

        //a)

        em.getTransaction().begin();
        
        Product product1 = new Product("Calendar Book", "A book with calendar and tables to make schedules for the customer");
        em.persist(product1);
        Product product2 = new Product("Winer Coat", "Winter Coat is good between 10'C and -20'C.");
        em.persist(product2);

        OrderLine orderLine1=new OrderLine(1);
        orderLine1.setProduct(product1);
        em.persist(orderLine1);

        OrderLine orderLine2=new OrderLine(2);
        orderLine2.setProduct(product2);
        em.persist(orderLine2);


        Customer customer1 = new Customer("Welda", "Elle");
        em.persist(customer1);

        Order order1=new Order(new Date());
        em.persist(order1);

        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);

        order1.setCustomer(customer1);
        
        em.getTransaction().commit();
        
        //b)

        em.getTransaction().begin();
        
        CD cd1 = new CD("Country Road", "Incudes country songs", "Jackson");
        em.persist(cd1);
        DVD dvd1 = new DVD("Happy Family", "About 4 member family in the real world", "comedy");
        em.persist(dvd1);
        Book book1 = new Book("Cartoon Book", "A book while writer is thinking about home away from home", "The the way back home");
        em.persist(book1);

        OrderLine orderLine3=new OrderLine(3);
        orderLine3.setProduct(cd1);
        em.persist(orderLine3);

        OrderLine orderLine4=new OrderLine(4);
        orderLine4.setProduct(dvd1);
        em.persist(orderLine4);

        OrderLine orderLine5=new OrderLine(5);
        orderLine5.setProduct(book1);
        em.persist(orderLine5);

        Customer customer2 = new Customer("Anna", "Cho");
        em.persist(customer2);

        Order order2=new Order(new Date());
        em.persist(order2);

        order2.addOrderLine(orderLine3);
        order2.addOrderLine(orderLine4);
        order2.addOrderLine(orderLine5);

        order2.setCustomer(customer2);
        
        em.getTransaction().commit();
        
        em.close();
    }
}
