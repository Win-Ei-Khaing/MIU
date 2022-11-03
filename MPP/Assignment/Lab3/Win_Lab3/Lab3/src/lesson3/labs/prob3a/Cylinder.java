package lesson3.labs.prob3a;

public class Cylinder {
	private double height;
	private double radius;

	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	public Cylinder(double radius) {
		this.radius = radius;
		this.height = 1;
	}

	public double getHeight(){
		return height;
	}

	public double computeVolume() {
		double volume = Math.PI * Math.sqrt(radius) * height;
		return volume;
	}
}
