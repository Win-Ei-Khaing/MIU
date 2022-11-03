package lesson11.wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Manager[] mgrArr = new Manager[2];
		mgrArr[0] = new Manager("Win", "To check employee performance");
		mgrArr[1] = new Manager("Ei", "To do report");

		Employee[] empArr = new Employee[2];
		empArr=mgrArr;
		//empArr[0] = new Employee("Win");
		//empArr[1] = new Manager("Win", "To check employee performance");


		System.out.println(Arrays.toString(empArr));

		System.out.println("-------------------------------------------------");
		List<Manager> mgrList = new ArrayList<Manager>();
		mgrList.add(new Manager("Win", "To check employee performance"));
		mgrList.add(new Manager("Ei", "To do report"));

		List<Employee> empListTest = new ArrayList<Employee>();
		empListTest.addAll(mgrList);
		System.out.println(empListTest.toString());
		System.out.println("-------------------------------------------------");
		//empListTest = mgrList; //will get compile error

		List<? extends Employee> empList = new ArrayList<Employee>();
		empList = mgrList;
		//empList.add(new Employee("Win"));
		//empList.add(new Manager("Win", "To check employee performance"));

		System.out.println(empList.toString());

		System.out.println("-------------------------------------------------");

		List<Integer> ints = new ArrayList<Integer>(); 
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		// nums.add(3.14); //compiler error 
		System.out.println(ints.toString()); 
		nums.add(null); //OK
		
		System.out.println(nums.get(2));
	}
}
