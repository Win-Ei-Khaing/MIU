package lab4_5.closedcurve.good;

public interface Polygon { 
	//example: For a rectangle, return would be [width, width, // length, length]
	public double[] getArrayOfSides();
	
	//returns the sum of the values in arr
	static double sum(double[] arr) 
	{
		double sum=0.0;
		for(double value : arr)
			sum+=value;
		return sum;
	}
	
	//returns the perimeter of the polygon 
	default double computePerimeter() {
		double[] arr= getArrayOfSides();
		return sum(arr);
	}
}
