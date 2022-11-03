package prob1;

public class DecoyDuck extends Duck{
	public DecoyDuck() {
		quackBehavior = new MuteQuack();
		flyBehavior = new CannotFly();
	}

	@Override
	void display() {
		System.out.println(" displaying");
	}

}
