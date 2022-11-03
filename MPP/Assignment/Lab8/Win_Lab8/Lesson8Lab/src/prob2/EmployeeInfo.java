package prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	private SortMethod method;

	public EmployeeInfo(SortMethod method) {
		this.method = method;
	}
	//Comparators are unaware of the value in method
	public void sort(List<Employee> emps) {
		if(method == SortMethod.BYNAME) {
			Collections.sort(emps, new EmployeeNameComparator());
		}
		else if(method == SortMethod.BYSALARY) {
			Collections.sort(emps, new EmployeeSalaryComparator());
		}
	}

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Joe", 50000));
		emps.add(new Employee("Andy", 60000));
		Employee joe = new Employee("Joe", 100000);
		Employee joe2 = new Employee("Joe", 200000);
		List<Employee> list = Arrays.asList(joe, joe2);
		Collections.sort(list, new EmployeeNameComparator());
		System.out.println(list);
		//		
		//		
		System.out.println("joe equals joe2? " + joe.equals(joe2));
		EmployeeNameComparator c = new EmployeeNameComparator();
		System.out.println("joe equals joe2? " + (c.compare(joe, joe2)==0) );


		/*
		EmployeeInfo ei = new EmployeeInfo(EmployeeInfo.SortMethod.BYNAME);
		ei.sort(emps);
		System.out.println(emps);
		ei = new EmployeeInfo(EmployeeInfo.SortMethod.BYSALARY);
		ei.sort(emps);
		System.out.println(emps);*/
		
		System.out.println("\nWin testing ...");
		Employee e1 = new Employee("Win", 7000);
		Employee e2 = new Employee("Win", 8000);
		System.out.println("EmployeeNameComparator e.compare(e1, e2) : "+(c.compare(e1, e2)==0));
		EmployeeComparatorFor2A ec2A = new EmployeeComparatorFor2A();
		System.out.println("EmployeeComparatorFor2A ec.compare(e1, e2) : "+ (ec2A.compare(e1, e2)==0));
	
	
		List<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		eList.add(e2);
		eList.add(new Employee("Su", 9000));
		eList.add(new Employee("A Win", 10000));
		System.out.println("\n2B");
		EmplyeeComparatorFor2B ec2B = new EmplyeeComparatorFor2B();
		ec2B.sort(eList, EmplyeeComparatorFor2B.SortMethod.BYNAME);
		System.out.println(eList.toString());
		ec2B.sort(eList, EmplyeeComparatorFor2B.SortMethod.BYSALARY);
		System.out.println(eList.toString());
		System.out.println("\n2C");
		EmplyeeComparatorFor2C ec2C = new EmplyeeComparatorFor2C();
		ec2C.sort(eList, EmplyeeComparatorFor2C.SortMethod.BYNAME);
		System.out.println(eList.toString());
		ec2C.sort(eList, EmplyeeComparatorFor2C.SortMethod.BYSALARY);
		System.out.println(eList.toString());
	}
}


