package prog12_1;

import java.util.logging.Logger;

public class Rectangle extends ClosedCurve {

	private double width;
	private double length;
	
	Logger log=Logger.getLogger("colsedcurve.good");
	public Rectangle(double width, double length) throws IllegalClosedCurveException{
		if(width < 0 || length < 0) {
			log.warning("Input dimensions of rectangle are not positive numbers.");
		throw new IllegalClosedCurveException("Illegal sizes for a rectangle : "+ width+", "+length);
		}
		this.length = length;
		this.width = width;
	}
	double computeArea() {
		return width*length;
	}
	


}
