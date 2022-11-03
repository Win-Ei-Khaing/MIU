package lesson7.labs.prob2;

public class Ellipse implements ClosedCurve {
	private double semiMajorAxis;
	private double ellipticIntegral;

	public Ellipse(double semiMajorAxis, double ellipticIntegral) {
		this.semiMajorAxis = semiMajorAxis;
		this.ellipticIntegral = ellipticIntegral;
	}

	@Override
	public double computePerimeter() {
		return 4 * semiMajorAxis * ellipticIntegral;
	}
}
