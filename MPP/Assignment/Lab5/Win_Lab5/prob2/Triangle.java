package prob2;

public final class Triangle extends ClosedCurve{
	private final double base;
	private final double height;

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	@Override
	double computeArea() {
		return (base * height)/2;
	}
}