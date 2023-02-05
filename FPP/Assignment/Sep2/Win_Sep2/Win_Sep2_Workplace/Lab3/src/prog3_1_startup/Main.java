package prog3_1_startup;

public class Main {

	public static void main(String[] args) {
		Employee employee=new Employee("WinEiKhaing", "Welda",10000.0, 2019, 05, 01);
		
		Account checkingAcc=new Account(employee, AccountType.CHECKING, 300);
		Account savingAcc=new Account(employee, AccountType.SAVINGS, 300);
		Account retirementAcc=new Account(employee, AccountType.RETIREMENT, 300);
		
		System.out.println(checkingAcc.toString());
		System.out.println(savingAcc.toString());
		System.out.println(retirementAcc.toString());
	}
}
