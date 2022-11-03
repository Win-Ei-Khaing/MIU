package prob2;

import java.util.Collections;
import java.util.List;

public class EmplyeeComparatorFor2C {
	static enum SortMethod {BYNAME, BYSALARY};
	public void sort(List<Employee> emps, final SortMethod method) {
		Collections.sort(emps, (e1, e2) -> {
			if(method == SortMethod.BYNAME) {
				return e1.name.compareTo(e2.name);
			} else {
				if(e1.salary == e2.salary) return 0;
				else if(e1.salary < e2.salary) return -1;
				else return 1;
			}
		});
	}
}