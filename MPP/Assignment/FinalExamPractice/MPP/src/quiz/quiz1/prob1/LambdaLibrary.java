package quiz.quiz1.prob1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaLibrary {
	public final static String IMPLEMENT = "implement!";

	// sample query
	public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE = (
			list, namelength, year) -> list.stream()
			.filter(e -> e.getName().length() > namelength)
			.filter(e -> e.getYearOfBirth() > year)
			.collect(Collectors.toList());

	// Query 1
	public final static Function<int[], Integer> QUERY1 = (list) -> IntStream
			.of(list).max().getAsInt();

	// Query 2
	public final static Function<int[], Integer> QUERY2 = (list) -> IntStream
			.of(list).reduce(0, (a, b) -> a + b * b);

	// Query 3
	public final static Function<int[], int[]> QUERY3 = (list) -> IntStream
			.of(list).filter(i -> i % 2 == 0).toArray();

	// Query 4
	public final static TriFunction<List<Integer>, Integer, Integer, List<Integer>> QUERY4 = (
			list, N, M) -> list.stream().filter(i -> i > N && i % 9 < M)
			.sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

	// Query 5
	static int index = 0;
	public final static BiFunction<List<Integer>, List<Integer>, Long> QUERY5 = (
			bigList, smallList) -> bigList
			.stream()
			.map(i -> {
				if (index + smallList.size() <= bigList.size()) {
					List<Integer> subList = bigList.subList(index, index
							+ smallList.size());
					index++;
					return subList;
				}
				return Arrays.asList();
			}).filter(a -> {
				boolean match = true;
				if(smallList.size() !=a.size() ) return false;
				for (int r = 0; r < smallList.size(); r++) {
					if (a.get(r) != smallList.get(r)) {
						match = false;
						break;
					}
				}
				return match;
			}).count();

	// QUERY6
	public final static TriFunction<List<Employee>, Integer, Integer, List<Pair>> QUERY6 = (
			list, lower, upper) -> list.stream()
			.filter(emp -> emp.getSalary() > lower && emp.getSalary() < upper)
			.sorted((emp1, emp2) -> {
				if (emp1.getName().compareTo(emp2.getName()) != 0) {
					return emp1.getName().compareTo(emp2.getName());
				} else {
					if (emp1.getSalary() == emp2.getSalary())
						return 0;
					else if (emp1.getSalary() < emp2.getSalary())
						return 1;
					else
						return -1;
				}
			}).map(emp -> new Pair(emp.getName(), emp.getSalary()))

			.collect(Collectors.toList());

	// QUERY7
	public final static Function<List<Transaction>, List<Transaction>> QUERY7 = (
			list) -> list.stream().sorted((t1, t2) -> {
		if (t1.getValue() == t2.getValue())
			return 0;
		else if (t1.getValue() < t2.getValue())
			return -1;
		else
			return 1;
	}).collect(Collectors.toList());

	// QUERY8
	public final static BiFunction<List<Transaction>, String, List<Trader>> QUERY8 = (
			list, city) -> list.stream().map(t -> t.getTrader()).distinct()
			.filter(t -> t.getCity().equals(city))
			.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
			.collect(Collectors.toList());
}
