package lesson9.labs.prob6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Prob6 {

	public static void main(String[] args) {
		List<Set<String>> listOfSets= new ArrayList<Set<String>>(){
			{
				add(new HashSet<String>(Arrays.asList("A","B")));
				add(new HashSet<String>(Arrays.asList("D")));
				add(new HashSet<String>(Arrays.asList("1","3","5")));
			}
			
		};
		
		Set<String> combinedSet= union(listOfSets);
		
		System.out.println(combinedSet);
	}
	
	public static Set<String> union(List<Set<String>> sets){
		Set<String> combinedSet = new LinkedHashSet<String>();
		sets.forEach(s-> combinedSet.addAll(s));
		return combinedSet;
	}
}
