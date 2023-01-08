package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        //Open a EntityManager
        em.getTransaction().begin();

        //Retrieve all students from the database and display their names
        //important: your query needs to be: from edu.mum.cs544.Students
        TypedQuery<Students> retrieveQuery1 = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> studentList1 = retrieveQuery1.getResultList();
        for (Students student : studentList1) {
            System.out.println("name= " + student.getName());
        }

        //Close the EntityManager
        em.getTransaction().commit();

        //---------------------------------------------------------------------------

        //Open a EntityManager
        em.getTransaction().begin();

        //Add an extra student to the database (you can choose his / her name)

        //getting max id from table first
        Integer maxId = em.createQuery("select max(s.id) from edu.mum.cs544.Students s", Integer.class).getSingleResult();
        Students newStudent = new Students((maxId+1), "Thae Su", "welda@miu.edu", "12345678");
        em.persist(newStudent);

        //Close the EntityManager
        em.getTransaction().commit();

        //---------------------------------------------------------------------------

        //Open a EntityManager
        em.getTransaction().begin();

        //Retrieve all students again from the database and display their names
        TypedQuery<Students> retrieveQuery2 = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> studentList2 = retrieveQuery2.getResultList();
        for (Students student : studentList2) {
            System.out.println("name= " + student.getName());
        }

        //Close the EntityManager
        em.getTransaction().commit();

        em.close();
    }
}
