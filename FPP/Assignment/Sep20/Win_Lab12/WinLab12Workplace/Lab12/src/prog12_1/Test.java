package prog12_1;

import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) {
		/*Triangle t=null;
		try {
			t=new Triangle(4,1,6);
		}
		catch(IllegalClosedCurveException e) {
			String msg=e.getMessage();
			System.out.println(msg);
		}
		
		Square s=null;
		try {
			Double d=-3.0;
			s=new Square(d);
		}
		catch(IllegalClosedCurveException e) {
			String msg=e.getMessage();
			System.out.println(msg);
			System.exit(0);
		}*/
		
		ClosedCurve[] objects=null;
		try {
			objects = new ClosedCurve[]  {new Triangle(4,5,6),
					new Square(3),
					new Rectangle(3,7),
					new Circle(-3)};
		}
		catch(IllegalTriangleException e) {
			System.out.println("Catched IllegalTriangleException");
			String msg=e.getMessage();
			//System.out.println(msg);
			JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		catch(IllegalClosedCurveException e) {
			System.out.println("Catched IllegalClosedCurveException");
			String msg=e.getMessage();
			System.out.println(msg);
			System.exit(0);
		}
		//compute areas
		for(ClosedCurve cc : objects) {
			String nameOfCurve = getClassNameNoPackage(cc.getClass());

			System.out.println("The area of this "+
					nameOfCurve+ 
					" is "+
					cc.computeArea());

		}

	}
	public static String getClassNameNoPackage(Class aClass){ 
		String fullClassName = aClass.getName();
		int index = fullClassName.lastIndexOf('.');
		String className = null;
		String packageName = null;


		//in this case, there is no package name
		if(index==-1) {
			return fullClassName;
		}
		else {
			//for other apps, may be useful to have this
			packageName = fullClassName.substring(0,index);

			className = fullClassName.substring(index+1);
			return className;
		}    


	}

}
