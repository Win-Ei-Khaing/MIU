package lab4_6.case2;

import java.util.GregorianCalendar;

public final class PersonWithJob extends Person {
	private double salary;

	public PersonWithJob(String n, GregorianCalendar dob, double s) {
		super(n, dob);
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
		boolean isEqual=getName().equals(pj.getName()) && getDateOfBirth().equals(pj.getDateOfBirth()) && this.salary==pj.salary;
		return isEqual;
		
	}
}
