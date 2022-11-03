package a;

import java.util.*;

public class Or {

	public static void main(String[] args) {
		List<Simple> list = Arrays.asList(new Simple(true), new Simple(false), new Simple(true));
		System.out.println(someSimpleIsTrue(list));
	}
	
	public static boolean someSimpleIsTrue(List<Simple> list) {
		/*boolean accum = false;
		for(Simple s: list) {
			accum = accum || s.flag;
		}
		return accum;*/
		
		Simple accum = new Simple(false);
		Optional<Simple> result = list.stream().reduce((Simple a,Simple b)->(a.flag||b.flag) ? ((a.flag)?a:b) : accum);
		return result.isPresent() ? result.get().flag : false;
	}

}
