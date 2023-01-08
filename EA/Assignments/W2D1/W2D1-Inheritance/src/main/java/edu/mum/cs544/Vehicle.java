package edu.mum.cs544;

import java.security.acl.Owner;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;

@Entity
@Inheritance
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Owner owner;

    @Column(name="manufacturer")
    private String make;

    private String model;

    private int year;

    private String color;

    @OneToMany
    @JoinColumn(name="wheels_id")
    @OrderColumn(name="wheels_ORDER")
    private List<Wheel> wheels;
}
