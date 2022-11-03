package exercise1;

public interface StringList {
	String[] strArray();
	int size();
	void incrementSize();
	
	/** Adds a string to the end of the list */
	default public void add(String s) {
		String[] strArr = strArray();
		strArr[size()] = s;
		incrementSize();
	}
	
	/** Gets the i_th string in the list */
	default public String get(int i) {
		String[] strArr = strArray();
		if (i < 0 || i >= size()) {
			return null;
		}
		return strArr[i];
	}
	
}
