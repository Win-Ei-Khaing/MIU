package edu.mum.cs544;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date birthDate;
    @Embedded
    private PhoneNumber number;
    @OneToMany
    @JoinColumn
    private List<Computer> computers = new ArrayList<>();
}
