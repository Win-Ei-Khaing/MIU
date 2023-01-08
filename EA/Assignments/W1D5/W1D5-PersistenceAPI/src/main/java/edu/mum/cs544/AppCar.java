package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        // save the car
        em.persist(car2);

        //Exercise Part A by Group12
        //Print “Em contains Car1 before clear” if it contains car1 after car2 has been persisted
        if(em.contains(car1)){
            System.out.println("Em contains Car1 before clear");
            //Exercise Part B by Group12
            //Change the price of car1 to 50000
            car1.setPrice(50000);
            em.getTransaction().commit(); //to update in DB

            em.getTransaction().begin(); //transaction start again to do next update
            car1 = em.merge(car1); //Updating the code (em.merge(car1);) to store the return value of merge into the Car1 variable
            car1.setYear("2022");
            em.getTransaction().commit();
        }

        //Clear the entity manager cache 
        em.clear();

        //Print “Em contains Car1 before clear” if it contains car1 after the clear
        if(em.contains(car1))
            System.out.println("Em contains Car1 before clear");
        //we just want to see message if it's not contained too
        else
            System.out.println("Em DOES NOT contain Car1 after clear");

        em.close();
        
        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
        }
        em.getTransaction().commit();
        em.close();
    }
}

