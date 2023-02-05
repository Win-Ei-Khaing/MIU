package prog3_3_startup;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(String s){
		//implement
	}
	
	public String get(int i){
		//implement
		return null;
	}
	
	public boolean find(String s){
		//implemement
		return false;
	}

	
	public boolean remove(String s){
		//implement
		return false;
	}
	
	
	private void resize(){
		//implement
	}
	public String toString(){
		//implement
		return "";
	}
	public int size() {
		return size;
	}

	public static void main(String[] args){
		MyStringList l = new MyStringList();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.remove("Mark");
		l.remove("Bob");
		System.out.println("The list of size "+l.size()+" is "+l);
	}

}
