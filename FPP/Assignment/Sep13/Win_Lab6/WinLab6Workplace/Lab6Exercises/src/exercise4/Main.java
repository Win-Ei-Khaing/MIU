package exercise4;

public class Main {
	public static void main(String[] args) {
		String[] strAry=new String[] {"Cy", "B", "Anna", "K", "Nwe"};
		StringSort strStort=new StringSort(new StringLengthComparator());
		String[] result=strStort.stringSort(strAry);
		for(String s : result)
			System.out.println(s);
	}
}
