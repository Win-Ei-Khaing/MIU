package prob1;

public class RedheadDuck extends Duck{
	public RedheadDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	void display() {
		System.out.println(" displaying");
	}

}
