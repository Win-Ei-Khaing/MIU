package lesson9.labs.prob11b;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import lesson9.labs.prob11a.Employee;


public class Main {
	public static final Function<List<Employee>, 
	List<String>> FILTERED_SORTED = (list) ->list.stream()
	.filter((Employee e)->e.getSalary()>100000)
	.filter((Employee e)->e.getLastName().matches("(?:N|O|P|Q|R|S|T|U|V|W|X|Y|Z).*"))
	.sorted(Comparator.comparing((Employee e)->e.getFirstName()))
	.map((Employee e)->e.getFirstName()+" "+e.getLastName())
	.collect(Collectors.toList());
	
	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				new Employee("John", "Sims", 110000),
				new Employee("Joe", "Stevens", 200000),
				new Employee("Andrew", "Reardon", 80000),
				new Employee("Joe", "Cummings", 760000),
				new Employee("Steven", "Walters", 135000),
				new Employee("Thomas", "Blake", 111000),
				new Employee("Alice", "Richards", 101000),
				new Employee("Donald", "Trump", 100000));

		System.out.println(FILTERED_SORTED.apply(list));
	}

}
