package lists.covariance;

import java.util.ArrayList;
import java.util.List;

public class MyListCovarianceDemoApp {

	public static void main(String[] args) {
		Employee m = new Manager("Allan", 1000.0);
		Employee[] mgrs = new Manager[3];
		
//		List<Employee> mgrs2 = new ArrayList<Manager>(); //-- compile error; no covariance
		List<? extends Employee> mgrs2 = new ArrayList<Manager>(); 
		
	}

}
