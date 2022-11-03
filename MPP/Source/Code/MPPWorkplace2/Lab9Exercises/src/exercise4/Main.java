package exercise4;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {
	//Use the reduce method to produce a single space-separated String
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Stream strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");
		//System.out.println(strings.reduce("", (x,y)->x+" "+y));
		
		//System.out.println(strings.reduce("", (x,y)->x+","+y));
		
		Optional<String> optionalStr = strings.reduce((x,y)->x+" "+ y);
		System.out.println(optionalStr.isPresent()? optionalStr.get():"");
	}

}