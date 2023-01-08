package problem04;

import java.util.ArrayList;
import java.util.List;

public class PowersetGenerator {
	
	static List<List<Integer>> powerSet(List<Integer> set){
		List<Integer> setcopy = new ArrayList<>(set);
		List<List<Integer>> powerset = new ArrayList<List<Integer>>();
		List<Integer> emptyset = new ArrayList<>();
		powerset.add(emptyset);
		while(!setcopy.isEmpty()) {
			Integer f = setcopy.remove(0);
			List<List<Integer>> temp = new ArrayList<>(powerset);
			for(List<Integer> subset: temp) {
				List<Integer> subsetcopy = new ArrayList<>(subset);
				subsetcopy.add(f);
				powerset.add(subsetcopy);
			}
		}
		return powerset;
	}
	
	public static void main(String[] args) {
		List<Integer> set = new ArrayList<>();
		set.add(2); set.add(5); set.add(7);
		List<List<Integer>> powerset = powerSet(set);
		
		System.out.println("For set: "+set);
		System.out.print("The subsets are: ");
		for(List<Integer> subset: powerset)
			System.out.print(subset+", ");
	}
}
