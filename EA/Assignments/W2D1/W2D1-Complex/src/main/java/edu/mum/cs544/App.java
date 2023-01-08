package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.mum.cs544.Domain.Appointment;
import edu.mum.cs544.Domain.Doctor;
import edu.mum.cs544.Domain.Patient;
import edu.mum.cs544.Domain.Payment;

//Exercise CXM.1 – Complex Mapping Exercise by Group12.
public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
                
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
       
        Doctor doctor = new Doctor("Eye doctor", "Frank", "Brown");
        em.persist(doctor);

        Patient patient = new Patient("John Doe", "100 Main Street", "Boston", "23114");
        em.persist(patient);
        
        Appointment appointment = new Appointment("15/05/08");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        
        Payment  payment= new Payment();
        payment.setPaydate("12/06/08");
        payment.setAmount(100);

        appointment.setPayment(payment);

        em.persist(appointment);

        em.getTransaction().commit();
        em.close();
    }
}
