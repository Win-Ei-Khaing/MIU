package edu.mum.cs544;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Computer {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
    @Column(name="cpu")
    private double CpuSpeed;
    private int ram;
}
