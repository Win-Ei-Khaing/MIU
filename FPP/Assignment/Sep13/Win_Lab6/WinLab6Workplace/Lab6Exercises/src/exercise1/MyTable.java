package exercise1;

public class MyTable {
	private Entry[] entries=new Entry[26];
	private int count=0;

	//returns the String that is matched with char c in the table
	public String get(char c){
		//implemented by win
		Entry result=null;
		for(Entry e:entries) {
			if(e.ch == c) {
				result=e;
				break;
			}
		}
		return result.toString();
	}
	//adds to the table a pair (c, s) so that s can be looked up using c 
	public void add(char c, String s) {
		//implemented by win
		//if(count<entries.length)//to avoid array index out of bound exception
			entries[count++]=new Entry(s, c);
	}
	//returns a String consisting of nicely formatted display
	//of the contents of the table
	public String toString() {
		String result="";
		for(Entry entry:entries) {
			if(entry!=null)
				result+=entry.toString()+"\n";
		}
		return result;
	}


	private class Entry {
		private String str;
		private char ch;
		Entry(String str, char ch){
			//implemented by win
			this.str=str;
			this.ch=ch;
		}
		//returns a String of the form "ch->str" 
		public String toString() {
			//implemented by win
			return String.format("%s->%s", ch, str);
		}
	}

}