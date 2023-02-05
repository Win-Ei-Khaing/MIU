package exercise1.model;

public class Professor extends DeptEmployee{
	private int numberOfPublications;

	public Professor(String name, double salary, int year, int month, int day, int numberOfPublications) {
		super(name, salary, year, month, day);
		this.numberOfPublications=numberOfPublications;
	}

	public int getNumberOfPublications() {
		return numberOfPublications;
	}

	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Number of publications : "+numberOfPublications;
	}
}
