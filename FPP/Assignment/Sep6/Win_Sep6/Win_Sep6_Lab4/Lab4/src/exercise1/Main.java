package exercise1;

import java.util.Scanner;

import exercise1.model.DeptEmployee;
import exercise1.model.Professor;
import exercise1.model.Secretary;

public class Main {

	public static void main(String[] args) {
		DeptEmployee prof1=new Professor("James", 10000.00, 2000, 01, 10, 10);
		DeptEmployee prof2=new Professor("Suzy", 30000.00, 2005, 03, 30, 10);
		DeptEmployee prof3=new Professor("Bok", 20000.00, 2008, 02, 20, 10);
	
		DeptEmployee secr1=new Secretary("Miley", 5000.00, 2007, 04, 05, 200);
		DeptEmployee secr2=new Secretary("John", 6000.00, 2008, 05, 06, 200);
		
		DeptEmployee[] department=new DeptEmployee[5];
		department[0]=prof1;
		department[1]=prof2;
		department[2]=prof3;
		department[3]=secr1;
		department[4]=secr2;
		
		for(DeptEmployee emp : department) {
			System.out.println(emp.toString());
		}
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\nDo you want to see the sumb of all salaries in the department? (Y/N)");
		String inputStr=sc.nextLine();
		if(inputStr.equalsIgnoreCase("Y")) {
			double sum=0.0;
			for(DeptEmployee emp : department) {
				sum+=emp.computeSalary();
			}
			System.out.println("Sum of all salaries : "+sum);
		}
	}

}