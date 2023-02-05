package prog4;

public final class Triangle {
	private final double base;
	private final double height;
	
	private final double side1;
	private final double side2;
	private final double side3;
	
	public Triangle(double base, double height) {
		this.base=base;
		this.height=height;
		
		//initializing 0.0 for those three final
		this.side1=0.0;
		this.side2=0.0;
		this.side3=0.0;
	}
	
	public Triangle(double side1, double side2, double side3) {
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
		
		//as question said to assume base as a longest side
		double max=side1;
		double min=side2;
		if(max<side2) {
			max=side2;
			min=max;
		}
		if(max<side3) {
			max=side3;
			min=max;
		}
		this.base=max;
		this.height=min;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public double computeArea() {
		return 0.5*base*height;
	}
}