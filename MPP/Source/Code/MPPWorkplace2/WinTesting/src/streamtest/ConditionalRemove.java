package streamtest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lesson11.wildcard.Employee;

public class ConditionalRemove {
	
	static class StrLengthCondition implements Predicate<String>{
		public boolean test(String s) {
			return s.length() == 5;
		}
	}	
	
	static class CharacterContainedCondition implements Predicate<String>{

		@Override
		public boolean test(String t) {
			return false;
			//return t.contains("k");
		}
	
	}
	
	static class SalaryCondition implements Predicate<Employee>{

		@Override
		public boolean test(Employee t) {
			return t.getSalary() < 60000;
		}
		
	}
	
	static class IntegerCondition implements Predicate<Integer>{

		@Override
		public boolean test(Integer t) {
			return t> 100;
		}

		
	}
		
		@SuppressWarnings("serial")
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<String>() {
				{
					add("Hello");
					add("Goodbye");
					//add("Welcome");
				}
				
			};
			
			ArrayList<String> list1 = new ArrayList<String>() {
				{
					add("Kick");
					add("Hello");
//					add("World");
//					add("Nick");
				}
			};
			
			ArrayList<Employee> list2 = new ArrayList<Employee>() {
				{
					add(new Employee("Bob", 55000));
					add(new Employee("Bob", 100000));
				}
			};
			
			ArrayList<Integer> list3 = new ArrayList<Integer>() {
				{
					add(64);
					add(124);
//					add(83);
//					add(345);
					
				}
			};
			
			//Test 
			System.out.println("i. Original - Remove: String length = 5 : " + conditionalRemove(list, new StrLengthCondition()));
			System.out.println("ii. Charcater k not contained condition : " + conditionalRemove(list1, new CharacterContainedCondition()));
			System.out.println("iii. Remove: Employee salary < 60000 condition : " + conditionalRemove(list2, new SalaryCondition()));
			System.out.println("iv. Remove: Integer value > 100 condition : " + conditionalRemove(list3, new IntegerCondition()));
		}
		
		//Original conditionalRemove
	/*
	public static List<String> conditionalRemove(ArrayList<String> list){
		StrLengthCondition cond = new StrLengthCondition();
		for(String s : list) {
			if(cond.test(s)) {
				list.remove(s);
			}
		}
		return list;
	}*/

	public static<T> List<T> conditionalRemove(ArrayList<T> list, Predicate<T> P) {
		List<T> a = new ArrayList<T>();
		for(T s : list) {
			if(!P.test(s)) {
				a.add(s);
			}
		}
		return a;
	}

}