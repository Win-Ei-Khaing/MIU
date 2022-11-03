
public class SuperClass {

	public static class Son extends Parent{
		 void print(){
			 super.print();
			System.out.println("Son");
		}
	}
	public static class Parent extends GrandParent{
		 void print(){
			System.out.println("Parent");
		}
	}
	public static abstract class GrandParent{
		abstract void print();
	}
		public static void main(String[] args) {
			GrandParent aa = new Son();
			aa.print();
		}

}
