package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
    @Id
    private long studentid;
    private String firstname;
    private String lastname;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(long studentid, String firstname, String lastname) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getStudentid() {
        return studentid;
    }

    public void setStudentid(long studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public boolean addCourse(Course course){
        if(courses.add(course))
            return true;
        return false;
    }

    public boolean removeCourse(Course course){
        if(courses.remove(course))
            return true;
        return false;
    }
    
}
