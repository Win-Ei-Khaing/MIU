package lesson4.labs.polymorphism;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Application {

	public static void main(String[] args) throws ParseException {
		Employee hourlyEmp1 = new Hourly("Walid",40, 40);
		Employee hourlyEmp2 = new Hourly("Rishi",40, 50);
		
		hourlyEmp1.print();
		hourlyEmp2.print();
	
		Employee salariedEmp1 = new Salaried("Eugene", 4000);
		Employee salariedEmp2 = new Salaried("Rishi", 8000);
		
		salariedEmp1.print();
		salariedEmp2.print();
		
		DateFormat dateFormat= new SimpleDateFormat("MM/dd/yy");
		Employee commissionedEmp1= new Commissioned("Walid",4000){
			{
				addOrder(new Order(1,dateFormat.parse("04/28/15"),6000));
				addOrder(new Order(1,dateFormat.parse("06/28/15"),8000));
				addOrder(new Order(1,dateFormat.parse("06/13/15"),9000));
			}
		};
		
		Employee commissionedEmp2= new Commissioned("Eugene",4000){
			{
				addOrder(new Order(1,dateFormat.parse("04/28/15"),1000));
				addOrder(new Order(1,dateFormat.parse("06/28/15"),1500));
				addOrder(new Order(1,dateFormat.parse("06/13/15"),3000));
			}
		};
		
		commissionedEmp1.print();
		commissionedEmp2.print();
	}

}

