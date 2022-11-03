package lesson7.labs.prob5;

public class DecoyDuck extends Duck{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("\tDecoy Duck");
	}

	@Override
	public void quack() {
		System.out.println("\tMute quack Sound");
	}

	@Override
	public void fly() {
		System.out.println("\tCannot Fly");
	}

}
