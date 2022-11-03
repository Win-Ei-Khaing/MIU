package lesson5.labs.prob2;

public abstract class Duck implements FlyBehavior, QuackBehavior {
	public abstract void display();

	public void fly(){
		DuckBehaviorFactory.getFlyBeahvior(this).fly();
	}

	public void quack() {
		DuckBehaviorFactory.getQuackBehavior(this).quack();
	}
	
	public void swim(){
		System.out.println("\tSwims");
	}
}
