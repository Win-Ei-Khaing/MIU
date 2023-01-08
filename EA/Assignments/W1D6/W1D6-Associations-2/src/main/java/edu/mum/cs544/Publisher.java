package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Publisher() {
    }
    public Publisher(String name) {
        this.name = name;
    }
    
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

    
}
