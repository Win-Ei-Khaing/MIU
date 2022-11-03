package streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class joining {
public static void main(String[] args) {
	String s=Stream.of("hello", "world", "i", "am","Win").collect(Collectors.joining(", "));
	System.out.println(s);
	
	System.out.println(Stream.of("hello", "world", "i", "am","Win").min((x,y)->{
		if(x.length()<y.length()) return -1;
		else if(x.length()>y.length()) return 1;
		else return 0;
	}));
	
	
	IntStream intStream=IntStream.of(0,1,2,3);
	//IntStream intStream1=IntStream.range(0, 10);
	IntStream intStream1=IntStream.rangeClosed(0, 10);
	System.out.println(intStream.boxed().collect(Collectors.toList()));
	System.out.println(intStream1.boxed().collect(Collectors.toList()));
	
	
	System.out.println(Stream.of("abc","bd","c").mapToInt(String::length).boxed().collect(Collectors.toList()));
	
	System.out.println("\n\n\n");
	
	String[] s1 = {"Hello","I", "am"};
	String[] s2 = {"Win","Ei", "Khaing"};
	
	List<String> merge = new ArrayList<String>();
	merge.addAll(Arrays.asList(s1));
	merge.addAll(Arrays.asList(s2));
	
	System.out.println(merge.stream().reduce("", (x,y)->x+(x==""?"" : " ")+y));
	
	//var aa = Stream.of(s1, s2).reduce("", (x,y)->x+(x==""?"" : " ")+y);
	
	System.out.println(Stream.of(Arrays.asList(s1), Arrays.asList(s2)).reduce(new ArrayList<String>(), (result, next) -> {
		List<String> newList = new ArrayList<String>(result);
		newList.addAll(next);
		return newList;
	}));
}
}
