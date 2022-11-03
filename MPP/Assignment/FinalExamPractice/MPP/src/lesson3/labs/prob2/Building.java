package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private List<Apartment> apartments;
	private int maintenanceCost;
	private String name;

	public String getName() {
		return name;
	}

	public Building(String name, int maintenanceCost) {
		this.name = name;
		this.maintenanceCost = maintenanceCost;
		apartments = new ArrayList<Apartment>();
	}

	public void addApartment(Apartment apartment) {
		this.apartments.add(apartment);
	}

	public int getProfit() {
		int totalRent = 0;
		for (Apartment apartment : this.apartments) {
			totalRent += apartment.getRent();
		}

		return totalRent - maintenanceCost;
	}

	
}
