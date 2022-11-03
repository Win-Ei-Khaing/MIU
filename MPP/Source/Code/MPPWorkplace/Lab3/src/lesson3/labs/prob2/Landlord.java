package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
	private List<Building> buildings;

	public Landlord() {
		buildings = new ArrayList<Building>();
	}

	public void addBuilding(Building building) {
		buildings.add(building);
	}

	public List<Building> getBuildings() {
		return buildings;
	}
	
	public double calcProfits() {
		double profit = 0.0;
		for(Building bdg : buildings) {
			profit += bdg.calcProfits();
		}
		return profit;
	}
}
