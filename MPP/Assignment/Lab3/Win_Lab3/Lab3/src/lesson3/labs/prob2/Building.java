package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private double width;
	private double length;
	private List<Apartment> apartments;
	private double maintenanceCost;

	public Building(double width, double length) {
		this.width = width;
		this.length = length;
		apartments = new ArrayList<Apartment>();
		maintenanceCost = 0.0;
	}

	public void addApartment(Apartment appartment) {
		apartments.add(appartment);
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public double calcProfits() {
		double profit = 0.0;
		double sumOfRent = 0.0;
		for(Apartment apt : apartments) {
			sumOfRent += apt.getRent();
		}
		profit = sumOfRent - maintenanceCost;
		return profit;
	}
}
