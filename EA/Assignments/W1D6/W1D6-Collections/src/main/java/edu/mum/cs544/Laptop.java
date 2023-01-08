package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private long id;
    private String brand;
    private String type;

    @ManyToOne
    @JoinColumn(name="aa")
    private Employee owner;
    
    public Laptop() {
    }
    public Laptop(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Employee getOwner() {
        return owner;
    }
    public void setOwner(Employee owner) {
        this.owner = owner;
    }
}
