package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Office {
    @Id
    @GeneratedValue
    private long roomnumber;
    private String building;

    @OneToMany
    @JoinColumn(name="office_id")
    @OrderColumn(name="sequence_for_office")
    private List<Employee> employees = new ArrayList<>();

    public Office() {
    }

    public Office(String building) {
        this.building = building;
    }

    public long getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(long roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee employee){
        if(employees.add(employee)){
            employee.setOffice(this);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(Employee employee){
        if(employees.remove(employee)){
            employee.setOffice(null);
            return true;
        }
        return false;
    }
}
