package swap;

public class Employee {
	private String name;
	private String address;
	public Employee(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	/*@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}*/
}
