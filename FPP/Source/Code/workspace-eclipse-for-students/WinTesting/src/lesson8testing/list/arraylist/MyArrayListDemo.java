package lesson8testing.list.arraylist;

public class MyArrayListDemo {
	public static void main(String[] args) {
		var l2=new MyArrayList<String>();
		l2.add("Win");
		l2.add("Ei");
		l2.add("Khaing");
		l2.print();
		System.out.println(l2.toString());
		
		System.out.println(l2.get(1));
		
		System.out.println(l2.contain("Ei"));
		System.out.println(l2.contain("Su"));
		
		l2.insert("Su", 1);
		l2.print();
		l2.insert("Su", 1);
		l2.print();
		
		l2.remove("Su");
		l2.print();
	}
}
