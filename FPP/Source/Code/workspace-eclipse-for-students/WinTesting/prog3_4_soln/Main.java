package prog3_4_soln;

public class Main {

	public static void main(String[] args) {
		
		Triangle triangle = new Triangle(1,1);
		Rectangle rect = new Rectangle(3,10);
		Circle circle = new Circle(8);
		
		System.out.println("Area of Triangle is " + triangle.computeArea());
		System.out.println("Area of Rectangle is " + rect.computeArea());
		System.out.println("Area of Circle is " + circle.computeArea());
		
		//using the side-side-side constructor of Triangle
		triangle = new Triangle(1,1,1.41421);
		System.out.println("Area of Triangle is " + Math.round(10*triangle.computeArea())/10.0);

	}

}
