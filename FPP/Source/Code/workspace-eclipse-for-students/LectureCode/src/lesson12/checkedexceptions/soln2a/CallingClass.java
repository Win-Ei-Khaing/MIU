package lesson12.checkedexceptions.soln2a;

public class CallingClass {
	void callingMethod() {
		Employee e = new Employee();
		e.makeCopy(); 
	}
	
	public static void main(String[] args) {
		CallingClass cc = new CallingClass();
		cc.callingMethod();
	}
}
