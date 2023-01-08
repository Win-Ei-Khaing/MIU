package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wheel {
    @Id
    @GeneratedValue
    private Long id;

    private int size;

    private double pressure;
}
