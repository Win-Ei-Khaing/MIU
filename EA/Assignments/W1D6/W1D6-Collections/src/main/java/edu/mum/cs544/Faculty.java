package edu.mum.cs544;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name="biography")
public class Faculty {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = true, table = "biography", length = 200)
    private String bio;
}
