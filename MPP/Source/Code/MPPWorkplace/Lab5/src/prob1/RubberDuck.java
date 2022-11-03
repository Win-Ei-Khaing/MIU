package prob1;

public class RubberDuck extends Duck{
	public RubberDuck() {
		quackBehavior = new Squeak();
		flyBehavior = new CannotFly();
	}

	@Override
	void display() {
		System.out.println(" displaying");
	}

}
