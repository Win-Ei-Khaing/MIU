package swap;

public class Main {
	public static void main(String[] args) {
		Employee e1=new Employee("Win", "Myanmar");
		Employee e2=new Employee("Ei","US");
		print(e1,e2);
		//swap(e1, e2);
		
		Employee temp=e1;
		e1=e2;
		e2=temp;
		
		print(e1,e2);
	}
	static void swap(Employee e1, Employee e2) {
		Employee temp=e1;
		e1=e2;
		e2=temp;
	}
	
	static void print(Employee e1, Employee e2) {
		System.out.println(e1+"\n"+e2);
		System.out.println(e1.getName()+"_"+e1.getAddress());
		System.out.println(e2.getName()+"_"+e2.getAddress());
	}
}
