package edu.mum.cs544;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Owners {
    @Id
    @GeneratedValue
    private Long id;
    private String owner;
}
