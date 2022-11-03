package prob3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		//list.forEach(new MyConsumer());	//(s -> System.out.println(s.toUpperCase())
		//list.forEach((s -> System.out.println(s.toUpperCase())));
		
		Consumer<String> cons = new Consumer<String>(){
			@Override
			public void accept(String s) {
				System.out.println(s.toUpperCase());
			}
		};
		
		list.forEach(cons);
	}
	
	static class MyConsumer implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	}
}