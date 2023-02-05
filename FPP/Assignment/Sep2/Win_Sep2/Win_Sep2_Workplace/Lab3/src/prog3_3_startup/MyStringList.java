package prog3_3_startup;

import java.util.StringJoiner;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(String s){
		//implemented by win
		resize();
		strArray[size]=s;
		size++;
	}
	
	public String get(int i){
		//implemented by win
		if(i<0 || i>strArray.length-1)
			return null;
		return strArray[i];
	}
	
	public boolean find(String s){
		//implememented by win
		for(int i=0;i<strArray.length;i++) {
			if(strArray[i].equalsIgnoreCase(s))
				return true;
		}
		return false;
	}
	
	public void insert(String s, int pos){
		//implemented by win
		if(pos>=0  && pos<strArray.length){
			strArray[pos]=s;
			size++;
		}
	}
	
	public boolean remove(String s){
		//implemented by win
		for(int i=0;i<strArray.length;i++) {
			if(strArray[i] != null) {
				if(strArray[i].equalsIgnoreCase(s)) {
					strArray[i]=null;
					size--;
					return true;
				}
			}
		}
		return true;
	}
	
	
	private void resize(){
		//implemented by win
		if(size>=strArray.length) {
			System.out.println("Resizing...");
			String[] newStrAry=new String[strArray.length*2];
			System.arraycopy(strArray, 0, newStrAry, 0, strArray.length);
			strArray=newStrAry;
			//System.out.println(strArray.length+"__"+newStrAry.length);
		}
	}
	public String toString(){
		//implemented by win
		StringJoiner sj=new StringJoiner(", ", "[", "]");
		for(int i=0;i<strArray.length;i++)
		{
			if(strArray[i]!=null)
				sj.add(strArray[i]);
		}
		return sj.toString();
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
		l.insert("Richard",3);
		System.out.println("The list of size "+l.size()+" after inserting Richard into pos 3 is "+l);
		l.insert("Tonya",0);
		System.out.println("The list of size "+l.size()+" after inserting Tonya into pos 0 is "+l);		
	
		//testing with question codes
		System.out.println("\nSecond test with codes from question\n");
		MyStringList m = new MyStringList(); 
		m.add("Bob"); 
		System.out.println("The list of size "+m.size+ " is "+m);
		m.add("Steve");
		System.out.println("The list of size "+m.size+ " is "+m);
		m.add("Susan");
		System.out.println("The list of size "+m.size+ " is "+m);
		m.add("Mark");
		System.out.println("The list of size "+m.size+ " is "+m);
		m.add("Dave");
		System.out.println("The list of size "+m.size+ " is "+m);
		m.remove("Mark");
		System.out.println("The list of size "+m.size+ " is "+m);
		m.remove("Bob");
		System.out.println("The list of size "+m.size+ " is "+m);
	}
}
