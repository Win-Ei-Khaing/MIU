package lab4_4.closedcurve.good;

public class Rectangle extends ClosedCurve implements Polygon{
	private final double width;
	private final double length;
	
	public Rectangle(double width, double length){
		this.width=width;
		this.length=length;
		
	}
	public double computeArea() {
		return width*length;
	}
	@Override
	public int getNumberOfSides() {
		return 4;
	}
	@Override
	public double computePerimeter() {
		return 2*width+2*length;
	}
}
