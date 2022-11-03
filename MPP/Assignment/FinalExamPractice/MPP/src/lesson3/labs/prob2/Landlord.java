package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
	public List<Building> buildings;

	public Landlord() {
		buildings = new ArrayList<Building>();
	}

	public void addBuilding(Building building) {
		buildings.add(building);
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	public int getTotalProfit() {
		int totalProfit = 0;
		for (Building building : this.buildings) {
			totalProfit += building.getProfit();
		}
		return totalProfit;
	}

	public static void main(String[] args) {

		Landlord landlord = new Landlord() {
			{
				addBuilding(new Building("B1", 300) {
					{
						addApartment(new Apartment(200));
						addApartment(new Apartment(300));
						addApartment(new Apartment(400));
					}
				});

				addBuilding(new Building("B2", 500) {
					{
						addApartment(new Apartment(400));
						addApartment(new Apartment(200));
						addApartment(new Apartment(700));
					}
				});
			}
		};

		System.out.println("Total landlord profit is " + landlord.getTotalProfit());

	}
}
