package edu.mum.cs544;

import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
    private String number;
    private String type;
}
