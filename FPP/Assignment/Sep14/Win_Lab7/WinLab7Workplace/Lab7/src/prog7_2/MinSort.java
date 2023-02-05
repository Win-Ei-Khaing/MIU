package prog7_2;

public class MinSort {

	public static void main(String[] args) {
		MinSort ms=new MinSort();
		String result = ms.sort("zwxuabfkafutbbbb");
		System.out.println(result);
	}

	private String sort(String s) {
		StringBuilder sb = new StringBuilder();
		if(s==null || s=="") return "";
		//int len=s.length();
		//for(int i=0;i<len;i++) {
			char minChar=minChar(s);
			int minpos=s.indexOf(minChar);

			sb.append(minChar);
			
			StringBuilder tempStringBuilder=new StringBuilder(s);
			char temp=s.charAt(0);
			tempStringBuilder.setCharAt(0, minChar);
			tempStringBuilder.setCharAt(minpos, temp);

			s=tempStringBuilder.toString().substring(1);
		//}


		return sb.toString()+sort(s);
	}
	
	char minChar(String s) {
		char ch=s.charAt(0);
		if(s.length()==1) return ch;
		char c=minChar(s.substring(1));
		return (ch<c)?ch:c;
	}


}