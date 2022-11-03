package solution;
public interface Polygon extends ClosedCurve{
	public double[] getSides();
	
	default double computePerimeter() {
		double perimeter = 0.0;
		double[] sides = getSides();
		for(double s : sides)
			perimeter += s;
		System.out.println("Polygon interface calculated : " + perimeter);
		return perimeter;
	}
}