package prog4_3.employeeinfo;

public class AccountList {
	private final int INITIAL_LENGTH = 2;
	private Account[] accountArray; 
	private int size;

	public AccountList() {
		accountArray = new Account[INITIAL_LENGTH];
		size = 0;
	}

	public void add(Account acc){
		if(size == accountArray.length) resize();
		accountArray[size++] = acc;
	}
	
	public Account get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return accountArray[i];
	}

	public boolean find(Account a){
		for(Account acc : accountArray){
			if(a.equals(acc)) { 
				return true;
			}
		}
		return false;
	}

	public void insert(Account a, int pos){
		if(pos > size) return;
		if(pos >= accountArray.length || size + 1 > accountArray.length) {
			resize();
		}
		Account[] temp = new Account[accountArray.length + 1];
		System.arraycopy(accountArray, 0, temp, 0, pos);
		temp[pos] = a;

		System.arraycopy(accountArray,pos,temp,pos+1, accountArray.length - pos);
		accountArray = temp;
		++size;

	}

	public boolean remove(Account a){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(accountArray[i].equals(a)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		Account[] temp = new Account[accountArray.length];
		System.arraycopy(accountArray, 0, temp, 0, index);
		System.arraycopy(accountArray, index + 1, temp, index, accountArray.length-(index+1));
		accountArray = temp;
		--size;
		return true;
	}


	private void resize(){
		//System.out.println("resizing");
		int len = accountArray.length;
		int newlen = 2*len;
		Account[] temp = new Account[newlen];
		System.arraycopy(accountArray, 0, temp, 0, len);
		accountArray = temp;
	}
	public String toString(){
		if(size>0) {
			StringBuilder sb = new StringBuilder("[");
			for(int i = 0; i < size-1; ++i){
				sb.append(accountArray[i].toString() + ", ");
			}
			sb.append(accountArray[size-1] + "]");
			return sb.toString();}
		else
			return null;
	}
	public int size() {
		return size;
	}

	/*public static void main(String[] args){
		AccountList l = new AccountList();
		Employee e1=new Employee("Bob", 1998, 01, 02);
		Account a1=new CheckingAccount(e1, 100000);
		Employee e2=new Employee("Susan", 2000, 02, 02);
		Account a2=new SavingsAccount(e2, 200000);
		Employee e3=new Employee("John", 2000, 02, 03);
		Account a3=new RetirementAccount(e3, 50000);
		Employee e4=new Employee("Bob", 1998, 01, 02);
		Account a4=new CheckingAccount(e4, 100000);

		System.out.println("The list of size "+l.size()+" is "+l.toString());
		l.add(a1);
		System.out.println("The list of size "+l.size()+" is "+l.toString());
		l.add(a2);
		System.out.println("The list of size "+l.size()+" is "+l.toString());
		l.add(a3);
		System.out.println("The list of size "+l.size()+" is "+l.toString());
		l.add(a4);
		System.out.println("The list of size "+l.size()+" is "+l.toString());
		l.remove(a2);
		System.out.println("The list of size "+l.size()+" is "+l);
		l.insert(a2,0);
		System.out.println("The list of size "+l.size()+" after inserting is "+l);	
	}*/

}