import Model.DatabaseConnectionManager;

public class SingletonDemo {

	public static void main(String[] args) {
		for(int i=0; i<3;i++) {
			DatabaseConnectionManager dbMan=DatabaseConnectionManager.getInstance();
			System.out.println(dbMan);
			System.out.println("Object creation time is "+DatabaseConnectionManager.count);
		}
	}

}
