import java.util.function.Supplier;
public class Lambda {

	public static void main(String[] args) {
		Supplier<Double> rand = () -> Math.random();
		Supplier<Double> lamba=Math::random;
		System.out.println(lamba.get());
		System.out.println(rand.get());

	}

}
