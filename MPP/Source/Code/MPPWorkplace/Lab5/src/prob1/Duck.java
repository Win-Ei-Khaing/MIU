package prob1;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void fly() {
		flyBehavior.fly();
	}
	
	public void quack() {
		quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println(" swimming");
	}
	
	abstract void display();
}
