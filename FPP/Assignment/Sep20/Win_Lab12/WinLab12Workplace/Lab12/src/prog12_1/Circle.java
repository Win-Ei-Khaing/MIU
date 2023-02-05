package prog12_1;

import java.util.logging.Logger;

public class Circle extends ClosedCurve {
	double radius;

	Logger log=Logger.getLogger("colsedcurve.good");
	public Circle(Double radius) throws IllegalClosedCurveException{
		if(radius < 0) {
			log.warning("Input dimensions of circle are not positive numbers.");
			throw new IllegalClosedCurveException("Illegal sizes for a circle : " + radius);
		}
		this.radius=radius.doubleValue();
	}
	public Circle(double radius) throws IllegalClosedCurveException {
		if(radius < 0) {
			log.warning("Input dimensions of circle are not positive numbers.");
			throw new IllegalClosedCurveException("Illegal sizes for a circle : " + radius);
		}
		this.radius = radius;
	}
	double computeArea() {
		return (Math.PI * radius * radius);
	}
}
