package lesson9testing;

public class ReverseString {

	static String reverse(String s) {
		if(s==null || s.length()==0) return s;
		char firstChar=s.charAt(0);
		return reverse(s.substring(1))+firstChar;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("Hello"));
	}

}
