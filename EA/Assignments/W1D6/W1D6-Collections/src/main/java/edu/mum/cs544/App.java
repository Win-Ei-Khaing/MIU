package edu.mum.cs544;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//This class is for Exercise CMP.1 – Mapping Collections by Group12.
public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
                
        EntityManager em = emf.createEntityManager();

        //a)
        em.getTransaction().begin();
        Employee employee1 = new Employee("Mi", "Sandi");
        Laptop laptop1=new Laptop("Apple", "Mackbook");
        em.persist(laptop1);
        employee1.addLaptop(laptop1);
        Laptop laptop2=new Laptop("Asus", "Notebook");
        em.persist(laptop2);
        employee1.addLaptop(laptop2);

        em.persist(employee1);
        em.getTransaction().commit();

        TypedQuery<Employee> employeeSelectQuery = em.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = employeeSelectQuery.getResultList();
        System.out.println("---Employee List---");
        for (Employee employee : employeeList) {
            System.out.println("firstname= " + employee.getFirstName() + ", lastname= " + employee.getLastName());

            System.out.println("Laptops : ");
            for(Laptop laptop : employee.getLaptops()){
                System.out.println("brand= "+laptop.getBrand() + ", type= "+laptop.getType());
            }

            System.out.println("----------");
        }

        TypedQuery<Laptop> laptopSelectQuery = em.createQuery("from Laptop", Laptop.class);
        List<Laptop> laptopList = laptopSelectQuery.getResultList();
        System.out.println("---Laptop List---");
        for (Laptop laptop : laptopList) {
            System.out.println("brand= "+laptop.getBrand() + ", type= "+laptop.getType() + 
            ", owner info: name= " + laptop.getOwner().getFirstName() + ", address= " + laptop.getOwner().getLastName());
        }

        //b)
        em.getTransaction().begin();

        Passenger passenger1 = new Passenger("Welda");
        Flight flight1=new Flight("A123", "Chicago", "Fairfield", new Date());
        em.persist(flight1);
        passenger1.addFlight(flight1);
        Flight flight2=new Flight("B456", "Fairfield", "Chicago", new Date());
        em.persist(flight2);
        passenger1.addFlight(flight2);

        em.persist(passenger1);
        em.getTransaction().commit();

        TypedQuery<Passenger> passengerSelectQuery = em.createQuery("from Passenger", Passenger.class);
        List<Passenger> passengerList = passengerSelectQuery.getResultList();
        System.out.println("---Passenger List---");
        for (Passenger passenger : passengerList) {
            System.out.println("name= " + passenger.getName());

            System.out.println("Flights : ");
            for(Flight flight : passenger.getFlights()){
                System.out.println("flightnumber= "+flight.getFlightnumber() + ", from= "+flight.getFrom()+
                ", to= "+flight.getTo() + ", date= "+flight.getDate());
            }

            System.out.println("----------");
        }

        //f)
        em.getTransaction().begin();

        School school1 = new School("MIU");
        Student student1=new Student(1L, "Bereket", "Alemayehu Tefera");
        em.persist(student1);
        school1.addStudent(student1);
        Student student2=new Student(2L, "Beza", "Bantayehu Zena");
        em.persist(student2);
        school1.addStudent(student2);
        Student student3=new Student(3L, "Win Ei", "Khaing");
        em.persist(student3);
        school1.addStudent(student3);

        em.persist(school1);
        em.getTransaction().commit();

        TypedQuery<School> schoolSelectQuery = em.createQuery("from School", School.class);
        List<School> schoolList = schoolSelectQuery.getResultList();
        System.out.println("---School List---");
        for (School school : schoolList) {
            System.out.println("name= " + school.getName());

            System.out.println("Students : ");
            for(Student student : new ArrayList<Student>(school.getStudents().values())){
                System.out.println("studentid= "+student.getStudentid() + ", firstname= "+student.getFirstname()+ ", lastname= "+student.getLastname());
            }

            System.out.println("----------");
        }

        em.close();
    }
}
