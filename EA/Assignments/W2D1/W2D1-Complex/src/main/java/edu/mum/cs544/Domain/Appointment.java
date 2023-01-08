package edu.mum.cs544.Domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    private String appdate;

    @OneToOne   
    @JoinColumn(name="patient")
    private Patient patient;

    @Embedded
    private Payment payment;
    
    @OneToOne
    @JoinColumn(name="doctor")
    private Doctor doctor;

    public Appointment() {
    }

    public Appointment(String appdate) {
        this.appdate = appdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
