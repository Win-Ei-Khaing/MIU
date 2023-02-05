package lesson9testing;

public class Merge {
	StringBuilder sb=new StringBuilder();
	String mergeString(String s1, String s2) {
		if(s1==null && s2==null) return null;
		if(s1==null || s1.isEmpty()) {
			sb.append(s2);
			return sb.toString();
		}
		if(s2==null || s2.isEmpty()) { 
			sb.append(s1);
			return sb.toString();
		}

		if(s1.charAt(0) < s2.charAt(0)) {
			sb.append(s1.charAt(0));
			return mergeString(s1.substring(1), s2);
		}
		else {
			sb.append(s2.charAt(0));
			return mergeString(s1, s2.substring(1));
		}
	}
	public static void main(String[] args) {
		Merge m=new Merge();
		System.out.println(m.mergeString("ac","bde"));
	}

}
