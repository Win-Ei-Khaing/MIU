package solution;

public class DecoyDuck extends Duck implements Unflyable, Unquackable {
	
	@Override
	public void display() {
		System.out.println("  displaying");
		
	}
}