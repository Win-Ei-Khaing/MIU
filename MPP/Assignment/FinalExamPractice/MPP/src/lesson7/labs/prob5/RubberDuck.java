package lesson7.labs.prob5;

public class RubberDuck extends Duck {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("\tRubber Duck");
	}

	@Override
	public void quack() {
		System.out.println("\tSqueak Sound");
	}

	@Override
	public void fly() {
		System.out.println("\tCannot Fly");
	}
}
