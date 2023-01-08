package edu.mum.cs544;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(name="studentId")
    private Long id;
    private String name;
    private int age;
    @OneToMany
    @JoinColumn
    private List<Enrollment> ccourses;
}
