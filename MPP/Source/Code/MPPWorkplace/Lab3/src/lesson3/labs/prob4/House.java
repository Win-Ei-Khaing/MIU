package lesson3.labs.prob4;

public class House extends Property{
	private double lotSize;

	public House(double lotSize) {
		super();
		this.lotSize = lotSize;
	}

	public double getLotSize() {
		//getS(new String[] {"a", "b", "c"});
		return lotSize;
	}
	
	public void getS(House[] aa) {
		for(House s : aa)
		System.out.println(s.lotSize);
	}

	@Override
	double computeRent() {
		return 0.1 * lotSize;
	}

}
