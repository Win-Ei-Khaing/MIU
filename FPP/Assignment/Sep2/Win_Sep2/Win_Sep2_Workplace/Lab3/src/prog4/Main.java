package prog4;

public class Main {

	public static void main(String[] args) {
		Triangle tri=new Triangle(4.0,6.0);
		System.out.println("Area of Triangle is " + tri.computeArea());
		
		Rectangle rec=new Rectangle(6.0,6.0);
		System.out.println("Area of Rectangle is " + rec.computeArea());
		
		Circle cir=new Circle(2.0);
		System.out.printf("Area of Circle is %.2f", cir.computeArea());
		
		
		String t = "[Hello\\tWorld!\\n]";
		System.out.println(t);
	}

}