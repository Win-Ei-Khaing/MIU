package prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderNum;
	private List<OrderLine> orderLines;
	
	Order(int orderNum){
		this.orderNum=orderNum;
		
		//added one orderLine because multiplicity is 1-1..*
		orderLines=new ArrayList<OrderLine>(); //just populate
		OrderLine orderLine=new OrderLine(this);
		orderLines.add(orderLine); //added one order line
	}

	public int getOrderNum() {
		return orderNum;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void addOrderLine() {
		OrderLine orderLine=new OrderLine(this);
		orderLines.add(orderLine); //adding more order line more than instantiated orde line
	}
	
	
}
