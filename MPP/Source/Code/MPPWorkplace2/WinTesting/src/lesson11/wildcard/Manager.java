package lesson11.wildcard;

public class Manager extends Employee{

	private String responsibility;
	public Manager(String name, String responsibility) {
		super(name,1000);
		this.responsibility=responsibility;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	@Override
	public String toString() {
		return super.getName()+" : "+responsibility;
	}
}
