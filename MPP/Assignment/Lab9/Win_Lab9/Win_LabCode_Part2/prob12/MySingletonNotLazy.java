import java.util.Optional;

public class MySingletonNotLazy {
	private static MySingletonNotLazy instance = null;
	private MySingletonNotLazy(){}
	public static MySingletonNotLazy getInstance() {
		instance = Optional.ofNullable(instance).orElseGet(()->new MySingletonNotLazy());
		return instance;
	}
}
