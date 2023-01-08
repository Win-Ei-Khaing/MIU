package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Toy{
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private String material;
    private String color;
}
