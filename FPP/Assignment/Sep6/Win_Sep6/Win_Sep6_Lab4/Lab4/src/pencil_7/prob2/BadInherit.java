package pencil_7.prob2;

public class BadInherit extends SuperClass{
	BadInherit(){
		System.out.println("In Badherit");
	}
	
	public static void main(String[] args) {
		new BadInherit();
	}
}

class SuperClass{
	SuperClass(){
		System.out.println("In SuperClass");
		new BadInherit();
	}
}
