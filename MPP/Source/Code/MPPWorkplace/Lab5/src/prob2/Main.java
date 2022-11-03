package prob2;

public class Main {
	public static void main(String[] args) {
		ClosedCurve[] closedCurves = {
				new Triangle(4, 6),
				new Rectangle(2, 4),
				new Circle(3)
		};
		double sum = 0;
		for(ClosedCurve cc : closedCurves) {
			sum += cc.computeArea();
		}

		System.out.printf("Sum of Areas = %.2f", sum);
	}
}
