package solution;

public interface Flyable {
	default void fly() {
		System.out.println("  fly with wings");
	}
}
