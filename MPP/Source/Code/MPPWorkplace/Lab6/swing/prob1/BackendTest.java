package swing.prob1;

import java.util.List;

public class BackendTest {
	public static void main(String[] args) {
		List<User> userList = Data.logins;
		for(User u : userList) {
			System.out.println(u.username + ", " + u.password + ", " + u.authorization);
		}

		System.out.println("______________________");

		User testUser = new User("Win", "111", null);
		User result = Util.findUser(userList, testUser);
		if(result != null)
			System.out.println(result.username + ", " + result.password + ", " + result.authorization);

		System.out.println("______________________");

		User newuser = new User("Win", "001", Auth.BOTH);
		Data.logins.add(newuser);

		for(User u : userList) {
			System.out.println(u.username + ", " + u.password + ", " + u.authorization);
		}

		System.out.println("______________________");

		List<String> bookList = Data.bookTitles;
		for(String s : bookList) {
			System.out.println(s);
		}
		
		System.out.println("______________________");
		
		Data.bookTitles.add("ei");
		
		System.out.println("______________________");
		
		for(String s : bookList) {
			System.out.println(s);
		}
	}
}
