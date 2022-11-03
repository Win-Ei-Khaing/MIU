package singletons;

public class Main {
	public static void main(String[] args) {	
		MySingletonLazy lazy = MySingletonLazy.getInstance();	
		MySingletonEnum myEnum = MySingletonEnum.INSTANCE;
		
		System.out.println(lazy);
		System.out.println(myEnum);
	}

}
