package prog12_1_startup.closedcurve.good;

public class Square extends ClosedCurve {
	double side;
	public Square(Double side){
		this(side.doubleValue());
	}
	public Square(double side) {
		this.side = side;
	}
	double computeArea() {
		return(side*side);
	}

}