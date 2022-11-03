package prob2;

public final class Rectangle extends ClosedCurve{
	private final double width;
	private final double length;
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	@Override
	double computeArea() {
		return width * length;
	}
}
