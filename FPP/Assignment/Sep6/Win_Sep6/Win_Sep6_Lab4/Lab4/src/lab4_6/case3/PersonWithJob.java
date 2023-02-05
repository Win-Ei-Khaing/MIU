package lab4_6.case3;

import java.util.GregorianCalendar;

public class PersonWithJob {
	private Person person;
	private double salary;

	public PersonWithJob(String n, GregorianCalendar dob, double s) {
		person=new Person(n, dob);
		this.salary=s;
	}
	
	public double getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object aPerson) {
		//System.out.println("Equals checking in sub");
		if(aPerson == null)
			return false;
		if(aPerson.getClass() != this.getClass())
			return false;
		
		PersonWithJob pj=(PersonWithJob)aPerson;
		boolean isEqual=this.person.equals(aPerson) && this.salary==pj.salary;
		return isEqual;
		
	}
}
