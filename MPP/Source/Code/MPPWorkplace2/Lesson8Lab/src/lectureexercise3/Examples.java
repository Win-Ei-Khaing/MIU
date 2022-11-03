package lectureexercise3;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
public class Examples {
	//type: Class::instanceMethod
	Function<String, String> upper1 = (String x) -> x.toUpperCase();
	Function<String, String> upper2 = String::toUpperCase;

	//Method reference type: Class::instanceMethod
	Function<Employee, String> f1 = (Employee e)->e.getName();
	Function<Employee, String> f2 = Employee::getName;

	//Method reference type: Class::instanceMethod
	BiConsumer<Employee, String> f3 = (Employee e,String s)->e.setName(s);
	BiConsumer<Employee, String> f4 = Employee::setName;

	//Method reference type: Class::instanceMethod
	BiFunction<String, String, Integer> f5 = (String s1,String s2) -> s1.compareTo(s2);
	BiFunction<String, String, Integer> f6 = String::compareTo;

	//Method reference type: Class::staticMethod
	BiFunction<Integer, Integer, Double> f7 = (Integer x,Integer y) -> Math.pow(x,y);
	BiFunction<Integer, Integer, Double> f8 = Math::pow;

	//Method reference type: Class::instanceMethod
	Function<Apple, Double> f9 = (Apple a) -> a.getWeight();
	Function<Apple, Double> f10 = Apple::getWeight;

	//Method reference type: Class::staticMethod
	Function<String, Integer> f11 = (String x) -> Integer.parseInt(x);
	Function<String, Integer> f12 = Integer::parseInt;

	//Method reference type: object::instanceMethod
	EmployeeNameComparator comp = new EmployeeNameComparator();
	BiFunction<Employee, Employee, Integer> f13 = (Employee e1, Employee e2) -> comp.compare(e1,e2);
	BiFunction<Employee, Employee, Integer> f14 = comp::compare;

	public void evaluator() {
		System.out.println(upper2.apply("hello"));
		System.out.println("Questin A : " + f2.apply(new Employee("Win Ei Khaing")));

		System.out.println("\nQuestin B : ");
		Employee eTest = new Employee("Win Ei Khaing");
		f4.accept(eTest, "Thae Su");
		System.out.println("New name is : " + eTest.getName());

		System.out.println("\nQuestion C : ");
		System.out.println(f6.apply("Ee", "Bb"));

		System.out.println("\nQuestion D : ");
		System.out.println(f8.apply(2, 2));

		System.out.println("\nQuestion E : ");
		System.out.println(f10.apply(new Apple(10.25)));

		System.out.println("\nQuestion F : ");
		System.out.println(f12.apply("1"));

		System.out.println("\nQuestion G : ");
		Employee eTest1 = new Employee("Win");
		Employee eTest2 = new Employee("Win");
		System.out.println("Are " + eTest1.getName() + " and " + eTest2.getName() + " are equal? :" + (f14.apply(eTest1, eTest2)==0));
	}

	public static void main(String[] args) {
		Examples e = new Examples();
		e.evaluator();
	}
}
