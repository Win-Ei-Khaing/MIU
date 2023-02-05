package lesson7testing;

class MyClass {
	public static void main(String[] args) {
		new MyClass();
	}
	MyClass() {
		recurse("Hello");
	}
	String recurse(String s){
		if(s==null || s.equals("")) return "";
		int n = s.length();
		String t = "ehllo"; //rearrange characters of s return recurse(t);
		return recurse(t);
	}
}
