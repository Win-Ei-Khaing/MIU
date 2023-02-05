package lab4_7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

import lab4_7.employeeinfo.Employee;

public class Main {
	Employee[] emps = null;
	public static void main(String[] args) {
		new Main();
	}
	Main(){

		emps = new Employee[3];
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2,13);

		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);	

		StringJoiner sj1=new StringJoiner(", ", "[", "]");
		for(Employee e : emps) {
			sj1.add(e.toString());
		}
		System.out.println(sj1.toString());
		
		Arrays.sort(emps);
		
		System.out.println("After sorting : ");
		StringJoiner sj2=new StringJoiner(", ", "[", "]");
		for(Employee e : emps) {
			sj2.add(e.toString());
		}
		System.out.println(sj2.toString());
	}

	String getFormattedAccountInfo(){
		String displayText="\n";
		int sn=0;
		for(Employee e : emps){
			displayText+=(sn++)+". "+e.getFormattedAcctInfo()+"\n";
		}
		return displayText;
	}

	String getNames() {
		String displayText="\n";
		int sn=0;
		for(Employee e : emps){
			displayText+=(sn++)+". "+e.getName()+"\n";
		}
		return displayText;
	}

	MyStringList getAccountNames(int i) {
		MyStringList accNames=emps[i].getNamesOfAccounts();
		return accNames;
	}
}
