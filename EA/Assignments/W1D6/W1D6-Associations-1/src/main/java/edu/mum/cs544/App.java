package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//This class is for Exercise AMP.1 – Adding an Association by Group12.
public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
                
        EntityManager em = emf.createEntityManager();

        //testing owner class
        em.getTransaction().begin();
        Owner owner1 = new Owner("Welda", "Fairfield");
        //em.persist(owner1);
        System.out.println("Done owner persist");

        // printing out all owners
        TypedQuery<Owner> ownerRetrieveQuery1 = em.createQuery("from Owner", Owner.class);
        List<Owner> ownerList1 = ownerRetrieveQuery1.getResultList();
        for (Owner owner : ownerList1) {
            System.out.println("name= " + owner.getName() + ", address= " + owner.getAddress());
        }
        
        em.getTransaction().commit();
        //-------------------

        System.out.println("TESTING's DONE");

        em.getTransaction().begin();
        //createing two cars
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        car1.setOwner(owner1); //associates an owner
        em.persist(car1);
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        car2.setOwner(owner1);//associates an owner
        em.persist(car2);

        // printing out all cars with it's owner
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= " + car.getYear() + ", price= " + car.getPrice() 
            +", owner info: name= " + car.getOwner().getName() + ", address= " + car.getOwner().getAddress());
        }

        //---------------

        Customer c1=new Customer("Win");
        Customer c2=new Customer("Ei");
        Customer c3=new Customer("Khaing");
        Customer c4=new Customer("Welda");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);

        Restaurant r1=new Restaurant("Sky bar 1");
        Restaurant r2=new Restaurant("Sky bar 2");

        em.persist(r1);
        em.persist(r2);

        r1.addCustomer(c1);
        r1.addCustomer(c2);
        r1.addCustomer(c3);

        r2.addCustomer(c4);

        Food f1=new Pizza("Pizza 1", 110, r1, "Vege");

        em.persist(f1);
        
        r1.addFood(f1);

        // TypedQuery<Customer> cusQuery = em.createQuery("from ", Customer.class);
        // List<Customer> customerList = cusQuery.getResultList();
        // for (Customer c : customerList) {
        //     System.out.println("cust name : "+ c.getName());
        // }

        em.close();
    }
}
