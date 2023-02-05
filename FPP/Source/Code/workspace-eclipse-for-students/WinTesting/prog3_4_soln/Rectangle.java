package prog3_4_soln;

public final class Rectangle {
	private final double width;
	private final double length;
	public Rectangle(double width, double length){
		this.length = length;
		this.width = width;
	}
	public double computeArea() {
		return width*length;
	}


}
