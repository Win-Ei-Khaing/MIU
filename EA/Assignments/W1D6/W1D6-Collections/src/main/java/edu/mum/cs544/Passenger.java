package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany
    @JoinColumn(name="passenger_id")
    @OrderColumn(name="sequence")
    private List<Flight> flights = new ArrayList<>();

    //constructors
    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }
    //---------------------------------------------------

    //getter, setter 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights(){
        return flights;
    }
    
    //no setters for flights becasuse Hibernate provides its own implementations for collections
    //adding convient methods for flight
    public boolean addFlight(Flight flight){
        if(flights.add(flight))
            return true;
        return false;
    }

    public boolean removeFlight(Flight flight){
        if(flights.remove(flight))
            return true;
        return false;
    }
    //---------------------------------------------------
}
