package edu.mum.cs544.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CustomerOrder")
public class Order {
    @Id
    @GeneratedValue
    private Long orderid;
    private Date date;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order() {
    }

    public Order(Date date) {
        this.date = date;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean addOrderLine(OrderLine orderLine){
        if(orderLines.add(orderLine))
            return true;
        return false;
    }

    public boolean removeOrderLine(OrderLine orderLine){
        if(orderLines.remove(orderLine))
            return true;
        return false;
    }
}
