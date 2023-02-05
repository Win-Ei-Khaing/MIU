package lab4_5.closedcurve.good;

public final class Rectangle extends ClosedCurve implements Polygon{
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
	public double[] getArrayOfSides() {
		double[] sides= {width, width, length, length};
		return sides;
	}
}
