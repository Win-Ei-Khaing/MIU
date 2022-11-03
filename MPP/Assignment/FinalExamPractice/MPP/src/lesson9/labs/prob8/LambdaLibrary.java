package lesson9.labs.prob8;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public final static TriFunction<List<Employee>, Integer, Character, Long> countEmployees = (
			list, minSalary, firstChar) -> list
			.stream()
			.filter(emp -> emp.getSalary() > minSalary
					&& emp.getLastName().charAt(0) > firstChar).count();

	public final static TriFunction<List<Employee>, Integer, Character, String> searchEmployees = (
			list, minSalary, firstChar) -> list
			.stream()
			.filter(emp -> emp.getSalary() > minSalary
					&& emp.getFirstName().charAt(0) < firstChar)
			.map(emp -> emp.getFirstName().toUpperCase() + " "
					+ emp.getLastName().toUpperCase()).sorted()
			.collect(Collectors.joining(", "));
}
