package lesson7.labs.prob5;

public interface Quackable {
	public default void quack(){
		System.out.println("\tQuack Sound");
	}
}

