package lesson6testing;

public class MyClass {
	private MyInner inner;
	public MyInner getInner() {
		return inner;
	}

	private class MyInner{
		private int innerInt;
		MyInner(int x){
			this.innerInt=x;
		}
	}

	public static void main(String[] args) {
		MyClass c=new MyClass();
		var result = c.getInner();
		System.out.println(result);
	}
}
