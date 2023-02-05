package prog7_4;

public class DivideSort {

	public static void main(String[] args) {
		String s="peodnmcehijklbfga";
		System.out.println(s);
		System.out.println("\nAfter divideSort");
		String sortedString=divideSort(s);
		System.out.println(sortedString);
	}

	public static String divideSort(String s) {
		if(s==null) return null;
		if(s.length()==1 || s.length()==0) return s;
		int mid=s.length()/2;
		String sleft=divideSort(s.substring(0, mid));
		String sright=divideSort(s.substring(mid));
		Merge ms = new Merge();
		return ms.merge(sleft, sright);
	}
}
