package removedup;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Fruit[] fruitAry= {
				new Fruit("Apple"),
				new Fruit("Orange"),
				new Fruit("Apple")
		};

		System.out.println(Arrays.toString(fruitAry));

		Fruit[] uniqueFruitAry=removeDup(fruitAry);
		
		ArrayList<Fruit> fruitList=new ArrayList<Fruit>();
		for(Fruit s : uniqueFruitAry) {
		       if(s != null ) {
		          fruitList.add(s);
		       }
		    }
		
		System.out.println(Arrays.toString(fruitList.toArray()));
	}
	static Fruit[] removeDup(Fruit[] fruitAry) {
		Fruit[] clearFruits=new Fruit[fruitAry.length];
		int i=0;
		for(Fruit f : fruitAry) {
			if(!isContain(clearFruits, f))
				clearFruits[i++]=f;
		}
		return clearFruits;
	}
	static Boolean isContain(Fruit[] fruitAry, Fruit fruit) {
		for(Fruit f : fruitAry) {
			if(f!=null) {
				if(f.equals(fruit)) 
					return true;
			}
		}
		return false;
	}
}
