package Final.prob3.exam;

import java.util.List;
import java.util.Optional;

//DO NOT MODIFY METHOD SIGNATURE OR STATIC QUALIFIER
public class FindOldestPerson {
	public static Person findOldestPerson(List<Person> persons) {
		//Optional.ofNullable(persons).orElseGet(()->System.out.println("or else get"));

		//Optional<Person> oldest =  persons.stream().reduce((x, y)->x.getAge()>y.getAge()?x:y);
		//return oldest.isPresent()?oldest.get():null;
		
		//return persons.stream().reduce((x, y)->x.getAge()>y.getAge()?x:y).get();
		
		
		int len = (persons.stream().map(p->p.getName().length()).reduce((x,y)->x+y)).get();
		System.out.println(len);
		
		return persons.stream().reduce((x, y)->x.getAge()>y.getAge()?x:y).get();
		
		//return (persons==null || persons.size()==0)? null : persons.stream().reduce(persons.get(0), (x, y)->x.getAge()>y.getAge()?x:y);
		//		System.out.println(oldest.toString());
		//		
		//		
		//		// implement
		//		Person oldestPerson = persons.stream().reduce(persons.get(0),
		//				(p1, p2) -> {
		//					if (p1.getAge() > p2.getAge()) {
		//						return p1;
		//					} else {
		//						return p2;
		//					}
		//				});
		//		return oldestPerson;
	}

}