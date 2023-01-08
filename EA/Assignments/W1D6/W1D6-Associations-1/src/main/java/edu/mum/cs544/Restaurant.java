package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;

    @OneToMany
    private List<Customer> customers=new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Food> foods=new ArrayList<>();


    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer cus){
        this.customers.add(cus);
    }

    public void addFood(Food food){
        this.foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

}
