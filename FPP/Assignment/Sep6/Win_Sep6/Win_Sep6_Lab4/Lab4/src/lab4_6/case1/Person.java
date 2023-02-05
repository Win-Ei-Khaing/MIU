package lab4_6.case1;

import java.util.GregorianCalendar;

public class Person {
	private String name;
	private GregorianCalendar dateOfBirth;
	
	public Person(String name, GregorianCalendar dob) {
		this.name = name;
		dateOfBirth = dob;
	}

	public String getName() {
		return name;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null)
			return false;
		if(!(aPerson instanceof Person))
			return false;
		
		Person p=(Person)aPerson;
		boolean isEqual=this.name.equals(p.name) && this.dateOfBirth.equals(p.dateOfBirth);
		return isEqual;
		
	}
}