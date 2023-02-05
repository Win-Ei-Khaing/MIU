package lists.covariance;

public class Manager extends Employee {
	double bonus;
	
	Manager(String name, double bonus) {
		super(name);
		this.bonus = bonus;
	}
}
