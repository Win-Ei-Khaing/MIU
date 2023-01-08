package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long employeenumber;
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id", insertable = false, updatable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name="office_id", insertable = false, updatable = false)
    private Office office;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public long getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(long employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
