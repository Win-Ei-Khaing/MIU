package edu.mum.cs544;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "owner")
    private Set<Laptop> laptops = new HashSet<>();

    //constructors
    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //---------------------------------------------------

    //getter, setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    //no setters for laptops becasuse Hibernate provides its own implementations for collections
    //adding convient methods for laptop
    public boolean addLaptop(Laptop laptop){
        if(laptops.add(laptop)){
            laptop.setOwner(this);
            return true;
        }
        return false;
    }

    public boolean removeLaptop(Laptop laptop){
        if(laptops.remove(laptop)){
            laptop.setOwner(null);
            return true;
        }
        return false;
    }
    //---------------------------------------------------

    //because we use Set, we need to implement hashCode and equals
    //they are generated with the help of IDE
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((laptops == null) ? 0 : laptops.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id != other.id)
            return false;
        if (laptops == null) {
            if (other.laptops != null)
                return false;
        } else if (!laptops.equals(other.laptops))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }
    //---------------------------------------------------
}
