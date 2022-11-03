public class MySingletonTest {
	public static void main(String[] args) {
		MySingletonLazy lazySingleton1 = MySingletonLazy.getInstance();
		System.out.println(lazySingleton1);
		MySingletonLazy lazySingleton2 = MySingletonLazy.getInstance();
		System.out.println(lazySingleton2);
		
		System.out.println("\nAfter using Optional.ofNullable(instance).orElseGet(()->new MySingletonNotLazy()) : \n");
		MySingletonNotLazy notLazySingleton1 = MySingletonNotLazy.getInstance();
		System.out.println(notLazySingleton1);
		MySingletonNotLazy notLazySingleton2 = MySingletonNotLazy.getInstance();
		System.out.println(notLazySingleton2);
	}
}
