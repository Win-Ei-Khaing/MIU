package lesson3.labs.prob4;

public class Admin {
	public static double computeTotalRent(Object[] properties) {
		double totalRent = 0;
		for (Object o : properties) {
			Property p = (Property) o;
			totalRent += p.computeRent();
			/*if (o instanceof House) {
				House h = (House) o;
				totalRent += h.computeRent();
			}
			else if (o instanceof Condo) {
				Condo h = (Condo) o;
				totalRent += h.computeRent();
			}
			else if (o instanceof Trailer) {
				Trailer h = (Trailer) o;
				totalRent += h.computeRent();
			}	*/
		}
		return totalRent;
	}
	
	public static void listProperties(Object[] properties) {
		System.out.println("\nList of properties: ");
		for (Object o : properties) {
			System.out.println(o.getClass().getSimpleName());
		}
	}
}
