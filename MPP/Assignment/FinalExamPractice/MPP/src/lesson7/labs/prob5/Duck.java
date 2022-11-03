package lesson7.labs.prob5;

public abstract class Duck implements Flyable, Quackable {
	public abstract void display();

	public void swim(){
		System.out.println("\tSwims");
	}
}
