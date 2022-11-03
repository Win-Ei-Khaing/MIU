package lesson3.labs.prob4;

public class Condo extends Property{
	private int numFloors;

	public Condo(int numFloors) {
		super();
		this.numFloors = numFloors;
	}

	public double getNumFloors() {
		return numFloors;
	}

	@Override
	double computeRent() {
		return 400 * numFloors;
	}
}
