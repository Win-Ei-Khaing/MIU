package prog4_3;

import java.util.Scanner;

import prog4_3.employeeinfo.AccountType;
import prog4_3.employeeinfo.Employee;

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

		try {	
			boolean isContinue=true;
			while(isContinue)
			{
				Scanner sc = new Scanner(System.in);
				//asking options to process
				System.out.print("A. See a report of all accounts \n"
						+ "B. Make a deposit. \n"
						+ "C. Make a withdrawal. \n"
						+ "Make a selection (A/B/C) :");
				String answer = sc.next();
				//seeing all account info
				if(answer.equalsIgnoreCase("A")){
					String info = getFormattedAccountInfo();
					System.out.println(info);
				}
				//making deposit
				else if(answer.equalsIgnoreCase("B") || answer.equalsIgnoreCase("C") ){
					String info = getNames();
					System.out.println(info);
					//asking to choose employee
					System.out.println("Select an employee: (type a number) ");

					int empNum = Integer.parseInt(sc.next());
					if(empNum >= 0 && empNum < emps.length)
					{
						String displayText="";
						MyStringList accList=getAccountNames(empNum);
						for(int x=0;x<accList.size();x++)
							displayText+=x+". "+accList.get(x)+"\n";
						System.out.println(displayText);
						//asking account
						System.out.println("Select an account: (type a number) ");

						int accTypeNum = Integer.parseInt(sc.next());
						if(accTypeNum >= 0 && accTypeNum < accList.size())
						{
							//making deposit
							if(answer.equalsIgnoreCase("B"))
							{
								System.out.println("Deposit amount: ");
								//asking amount
								double amount = Double.parseDouble(sc.next());

								if(amount > 0){
									emps[empNum].deposit(accTypeNum, amount);

									System.out.printf("$%.1f has been deposited in the %s account of %s\n\n",
											amount, 
											accList.get(accTypeNum),
											emps[empNum].getName());
								}
							}
							//making withdrawal
							else if(answer.equalsIgnoreCase("C"))
							{
								System.out.println("Withdraw amount: ");
								//asking amount
								double amount = Double.parseDouble(sc.next());

								if(amount > 0){
									if(emps[empNum].withdraw(accTypeNum, amount))
										System.out.printf("$%.1f has been withdrawn from the %s account of %s\n\n",
												amount, 
												accList.get(accTypeNum),
												emps[empNum].getName());
									else
										System.out.println("Can't withdraw with this amount.");
								}
							}
						}
					}
				}

				System.out.println("Want to continue (Y/N)");
				String choice= sc.next();
				if(!choice.equalsIgnoreCase("Y")) {
					isContinue=false;
					System.out.println("Thank you for testing");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Application is stopped because of this error -"+e.getMessage()+"-");
		}
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
