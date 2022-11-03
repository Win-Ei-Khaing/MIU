package solution;

public interface Squeakable extends Quackable {
	default void quack() {
		System.out.println("  squeaking");
	}
}
