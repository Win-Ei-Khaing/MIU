package streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prob4 {
	//IMPLEMENT
	public static <T> ArrayList<T> combine(Stream<ArrayList<T>> stream) {
	
//		Optional<ArrayList<T>> ot= stream.reduce((x, y)->{
//			ArrayList<T> result =new ArrayList<T>();
//			result.addAll(x);
//			result.addAll(y);
//			return result;
//		});
		
		
		return stream.reduce(new ArrayList<T>(), (x,y)->{x.addAll(y); return x;});
		//return ot.isPresent()?ot.get():null;	 
	}
	
	public static void testCombine() {
		ArrayList<ArrayList<String>> mainList = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<String>() {
			{
				add("hello");add("there");
			}
		};
		ArrayList<String> list2 = new ArrayList<String>() {
			{
				add("goodbye");add("there");
			}
		};
		mainList.add(list1);
		mainList.add(list2);
		System.out.println(combine(mainList.stream()));
	}
	public static void main(String[] args) {
		testCombine();
	}
}
