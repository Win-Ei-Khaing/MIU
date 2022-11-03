package solution;

public interface Unflyable extends Flyable {
	default void fly() {
		System.out.println("  cannot fly");
	}
}
