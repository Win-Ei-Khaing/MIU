package lab4_6.case1;

import java.util.GregorianCalendar;

public class Main {
	public static void main(String[] args) {
		GregorianCalendar dob=new GregorianCalendar(1997, 05, 25);
		Person per1=new Person("Win", dob);
		Person per2=new PersonWithJob("Win", dob, 10000);
		Person per3=new PersonWithJob("Win", dob, 20000);
		
		System.out.println(per1.equals(per2));
		System.out.println(per2.equals(per1));
		System.out.println(per2.equals(per3));
		System.out.println(per3.equals(per2));
	}
}
