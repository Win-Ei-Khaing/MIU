package lab4_5.closedcurve.good;

public class Test3 {
	public static void main(String[] args) {
		Polygon[] objects = {new Square(3),
				new Triangle(4,5,6),
				new Rectangle(3,4)};
		//compute areas
		for(Polygon pg : objects) {
			System.out.println("For this "+pg.getClass().getSimpleName()+
					" \n  Perimeter = "+pg.computePerimeter());			
		}
	}
}
