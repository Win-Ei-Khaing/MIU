package lab4_4.closedcurve.good;

public class Test2 {
	public static void main(String[] args) {
		Polygon[] objects = {new Square(3),
				new Triangle(4,5,6),
				new Rectangle(3,4)};
		//compute areas
		for(Polygon pg : objects) {
			System.out.println("For this "+pg.getClass().getSimpleName()+
					" \n  Number of sides = "+pg.getNumberOfSides()+
					" \n  Perimeter = "+pg.computePerimeter());			
		}
	}
}
