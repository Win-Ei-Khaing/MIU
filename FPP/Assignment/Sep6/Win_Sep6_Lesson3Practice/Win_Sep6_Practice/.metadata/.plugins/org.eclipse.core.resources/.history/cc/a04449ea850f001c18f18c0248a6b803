package Model;

public class DatabaseConnectionManager {
	public static int count = 0;
	private static DatabaseConnectionManager instance;
	private DatabaseConnectionManager() {
		count++;
	}
	
	public static DatabaseConnectionManager getInstance() {
		if(instance == null) {
			instance = new DatabaseConnectionManager();
		}
		return instance;
	}
}
