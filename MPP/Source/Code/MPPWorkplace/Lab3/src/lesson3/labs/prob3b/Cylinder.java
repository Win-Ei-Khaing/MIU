package lesson3.labs.prob3b;

import java.util.ArrayList;
import java.util.List;

public class Cylinder {
	private double height;
	private double radius;
	private List<Circle> circles;

	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
		circles = new ArrayList<Circle>();
		
		//as cylinder has two circles, going to instantiate two circle by using radius
		Circle circle = new Circle(radius);
		circles.add(circle);
		circles.add(circle);
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
