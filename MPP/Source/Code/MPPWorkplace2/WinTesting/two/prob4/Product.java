package prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {

	static <T> List<Pair<T>> computeProduct(List<? extends T> first, List<? extends T> second){
		List<Pair<T>> result = new ArrayList<Pair<T>>();
		for (int i = 0; i < first.size(); i++) {
			for (int j = 0; j < second.size(); j++) {
				result.add(new Pair<T>(first.get(i), second.get(j)));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<Pair<Integer>> product = computeProduct(Arrays.asList(2,4,6), Arrays.asList(1,5));
		for (int i = 0; i < product.size(); i++) {
			System.out.println(product.get(i).toString());
		}
		
		List<Pair<String>> product1 = computeProduct(Arrays.asList("a","b","c"), Arrays.asList("d","e"));
		for (int i = 0; i < product1.size(); i++) {
			System.out.println(product1.get(i).toString());
		}
	}
}
