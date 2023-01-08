package problem04;

import java.util.ArrayList;
import java.util.List;

public class GenericPowerset {
	
	static <T> List<List<T>> powerSet(List<T> set){
		List<T> setcopy = new ArrayList<>(set);
		List<List<T>> powerset = new ArrayList<List<T>>();
		List<T> emptyset = new ArrayList<>();
		powerset.add(emptyset);
		while(!setcopy.isEmpty()) {
			T f = setcopy.remove(0);
			List<List<T>> temp = new ArrayList<>(powerset);
			for(List<T> subset: temp) {
				List<T> subsetcopy = new ArrayList<>(subset);
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
