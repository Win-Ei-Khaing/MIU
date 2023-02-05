package exercise4;

public class MainLambda {
	public static void main(String[] args) {
		String[] strAry=new String[] {"Cy", "B", "Anna", "K", "Nwe"};
		StringSort strStort=new StringSort(
				(o1,o2)->{
				if(o1.length()<o2.length()) return -1;
				else if(o1.length()>o2.length()) return 1;
				return 0;
		});
		String[] result=strStort.stringSort(strAry);
		for(String s : result)
			System.out.println(s);
	}
}
