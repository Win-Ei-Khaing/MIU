package prob4;


public class Pair<T> {
	private T first;
    private T second;

    public Pair(T key, T value) {
		this.first = key;
		this.second = value;
    }
 
    public String toString(){
    	return "[" + first + ", " + second + "]";
    }
}