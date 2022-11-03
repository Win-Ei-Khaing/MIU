package prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ForEachExampleFor5b {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//list.forEach(String::toUpperCase);
		
		Function<String, String> f1 = String::toUpperCase;
		for(String s : list)
			System.out.println(f1.apply(s));
		
	}
}
