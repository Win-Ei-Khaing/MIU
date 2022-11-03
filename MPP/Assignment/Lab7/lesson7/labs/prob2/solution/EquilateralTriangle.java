package solution;

public class EquilateralTriangle implements Polygon{
	private double side;

	EquilateralTriangle(double side){
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double[] getSides() {
		return new double[] {side, side, side};
	}
}
