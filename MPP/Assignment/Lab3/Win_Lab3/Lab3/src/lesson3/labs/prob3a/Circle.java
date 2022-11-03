package lesson3.labs.prob3a;

public class Circle extends Cylinder{
	private double radius;

	public Circle(double radius) {
		super(radius);
		this.radius = radius;
	}

	public double getRadius(double radius) {
		this.radius = radius;
		return this.radius;
	}

	public double computeArea() {
		double area = Math.PI * Math.sqrt(radius);
		return area;
	}
}
