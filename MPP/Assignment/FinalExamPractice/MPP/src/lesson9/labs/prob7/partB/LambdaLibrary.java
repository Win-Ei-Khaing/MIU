package lesson9.labs.prob7.partB;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public final static TriFunction<List<Employee>, Integer, Character, String> searchEmployees = (
			list, minSalary, firstChar) -> list
			.stream()
			.filter(emp -> emp.getSalary() > minSalary
					&& emp.getLastName().charAt(0) > firstChar)
			.map(emp -> emp.getFirstName() + " " + emp.getLastName()).sorted()
			.collect(Collectors.joining(", "));
}
