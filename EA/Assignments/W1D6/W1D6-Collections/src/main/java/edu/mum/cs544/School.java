package edu.mum.cs544;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany
    @JoinTable
    private Map<Long, Student> students = new HashMap<>();

    //constructors
    public School() {
    }

    public School(String name) {
        this.name = name;
    }
    //---------------------------------------------------

    //getter, setter 
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

    public Map<Long, Student> getStudents(){
        return students;
    }
    
    //no setters for students becasuse Hibernate provides its own implementations for collections
    //adding convient methods for student
    public boolean addStudent(Student student){
        if(students.put(student.getStudentid(), student) != null)
            return true;
        return false;
    }

    public boolean removeStudent(Student student){
        if(students.remove(student.getStudentid()) != null)
            return true;
        return false;
    }
    //---------------------------------------------------
}
