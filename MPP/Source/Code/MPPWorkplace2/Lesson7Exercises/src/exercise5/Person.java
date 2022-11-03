package exercise5;
import java.util.*;

//Why doesn't this equals method work?
public class Person {
	private String name;
	Person(String n) {
		this.name = n;	
	}
	
	public boolean equals(Person aPerson) {
		if(aPerson == null) return false; 
		//if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		//boolean isEqual = this.name.equals(p.name);
		//return isEqual;
		return p.name.equals(name);
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("Joe");
		Person p2 = new Person("Joe");
		System.out.println(p1.equals(p2));
		
		List<Person> pList = new ArrayList<>();
		pList.add(p1);
		pList.add(p2);
		System.out.println(pList.contains(new Person("Joe")));
	}
	
	
}