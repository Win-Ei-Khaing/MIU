package lesson7testing;

public class RecursiveMinChar {
static Character min(String s) {
	if(s==null || s.length()==0) return null;
	char minChar=s.charAt(0);
	if(s.length()==1) return minChar;
	char nextMin=min(s.substring(1));
/*	if(minChar<nextMin) return minChar;
	else
		return nextMin; */
	return (minChar<nextMin) ? minChar : nextMin;
}
	
	public static void main(String[] args) {
		System.out.println(min("helloa"));
	}

}
