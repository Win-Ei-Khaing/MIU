package prob4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Good {
	public static void main(final String[] args) {
		Good good = new Good();
		List<String> strList = new ArrayList<String>();
		strList.add("Win");
		strList.add("Ei");
		strList.add("Khaing");
		strList.add("Welda");
		strList.add("Thae");
		System.out.println(good.countWords(strList, 'e', 'i', 4));	
	}
	
	public int countWords(List<String> words, char c, char d, int len) {
		List<String> result =words.stream()
				.filter(str -> str.length() == len) //checking len equal
				.filter(str -> str.indexOf(c) >= 0) //checking c include 
				.filter(str -> str.indexOf(d) < 0) //checking d not include
				.collect(Collectors.toList());

		System.out.println(result.toString());
		return result.size();
	}
}
