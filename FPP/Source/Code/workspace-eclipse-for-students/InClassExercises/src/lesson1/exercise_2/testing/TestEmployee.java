package lesson1.exercise_2.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import lesson1.exercise_2.program.Address;
import lesson1.exercise_2.program.Employee;

public class TestEmployee {
	/** Tests that the formatted string representation of Employee is correct */
	@Test
	public void testToString() {
		
		/*
		 Steps: 
		 1. Create a new home Address with this information :
		 
		    street:  "10 Adams"
		    city:    "Fairfield"
		    state:   "IA"
		    zip:     "52556"
		 
		 2. Create a new work Address with this information:
		   
		    street:  "110 Burlington" 
		    city:    "Fairfield" 
		    state:   "IA" 
		    zip:     "52556"
		    
		 3. Create a new Employee whose home and work addresses are as above and
		    
		    first name: "Joe"
		    last name:  "Smith"
		    salary:     100000
		    
		    Use the methods setXXX in Employee to set the salary and addresses
		    
		 4. call assertEquals to compare output of toString for the Employee you
		    just created and the String you expect to see "[Joe Smith]" 
		*/
	}
}
