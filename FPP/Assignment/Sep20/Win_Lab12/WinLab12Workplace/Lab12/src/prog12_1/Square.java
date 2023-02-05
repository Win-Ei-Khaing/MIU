package prog12_1;

import java.util.logging.Logger;

public class Square extends ClosedCurve {
	double side;
	
	Logger log=Logger.getLogger("colsedcurve.good");
	public Square(Double side) throws IllegalClosedCurveException{
		//this(side.doubleValue());
		if(side < 0) {
			log.warning("Input dimension for square is not a positive number.");
		throw new IllegalClosedCurveException("Illegal sizes for a square : "+ side);
		}
		this.side=side.doubleValue();
	}
	public Square(double side) throws IllegalClosedCurveException {
		if(side < 0) {
			log.warning("Input dimension is not a positive number.");
		throw new IllegalClosedCurveException("Illegal sizes for a square : "+ side);
		}
		this.side = side;
	}
	double computeArea() {
		return(side*side);
	}

}
