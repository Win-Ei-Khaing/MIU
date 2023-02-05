package prog13_2_startup;

import java.util.ArrayList;
import java.util.List;

public class Person {
	List<Address> addresses = new ArrayList<Address>();
	String firstName, lastName, ssn;
	public Person(String f, String l, String ssn){
		firstName = f;
		lastName = l;
		this.ssn = ssn;
	}
	public void addAddress(Address add) {
		addresses.add(add);
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSsn() {
		return ssn;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	
}
