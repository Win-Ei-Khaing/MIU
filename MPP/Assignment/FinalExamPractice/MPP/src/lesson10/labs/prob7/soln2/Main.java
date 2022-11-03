package lesson10.labs.prob7.soln2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(
				new Employee("Joe", "Davis", 120000), new Employee("John",
						"Sims", 110000),
				new Employee("Joe", "Stevens", 200000), new Employee("Andrew",
						"Reardon", 80000), new Employee("Joe", "Cummings",
						760000), new Employee("Steven", "Walters", 135000),
				new Employee("Thomas", "Blake", 111000), new Employee("Alice",
						"Richards", 101000), new Employee("Donald", "Trump",
						100000));

		printEmps(emps);

	}

	private static void printEmps(List<Employee> list) {
		System.out.println(asString(list));
	}

	public static String asString(List<Employee> emps) {
		return emps.stream().filter(Main::salaryGreaterThan100000)
				.filter(Main::lastNameLargerThanM)
				.map(Main::fullName).sorted()
				.collect(Collectors.joining(", "));
	}

	public static boolean salaryGreaterThan100000(Employee emp){
		return emp.getSalary() > 100000;
	}

	public static boolean lastNameLargerThanM(Employee emp){
		return emp.getLastName().charAt(0) > 'M';
	}
	
	public static String fullName(Employee e) {
		return e.getFirstName() + " " + e.getLastName();
	}

}
