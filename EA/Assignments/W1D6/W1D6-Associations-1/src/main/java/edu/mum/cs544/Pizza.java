package edu.mum.cs544;

import javax.persistence.Entity;

@Entity
public class Pizza extends Food{
    private String topping;

    public Pizza(String topping) {
        this.topping = topping;
    }

    public Pizza(String name, int calories, Restaurant restaurant, String topping) {
        super(name, calories, restaurant);
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }


}
