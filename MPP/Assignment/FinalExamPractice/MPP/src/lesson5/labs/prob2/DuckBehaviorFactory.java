package lesson5.labs.prob2;

import java.util.HashMap;

public class DuckBehaviorFactory {
	static HashMap<Class<? extends Duck>, FlyBehavior> flyMap = new HashMap<>();
	static HashMap<Class<? extends Duck>, QuackBehavior> quackMap = new HashMap<>();
	static {
		flyMap.put(RubberDuck.class, new CannotFly());
		flyMap.put(DecoyDuck.class, new CannotFly());
		flyMap.put(MallardDuck.class, new FlyWithWings());
		flyMap.put(RedheadDuck.class, new FlyWithWings());
		
		quackMap.put(RubberDuck.class, new Squeak());
		quackMap.put(DecoyDuck.class, new MuteQuack());
		quackMap.put(MallardDuck.class, new Quack());
		quackMap.put(RedheadDuck.class, new Quack());
	}

	public static FlyBehavior getFlyBeahvior(Duck duck) {
		Class<? extends Duck> cl = duck.getClass();
		if (!flyMap.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No FlyBehavior found for this Duck");
		}
		return flyMap.get(cl);
	}

	public static QuackBehavior getQuackBehavior(Duck duck) {
		Class<? extends Duck> cl = duck.getClass();
		if (!quackMap.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No QuackBehavior found for this Duck");
		}
		return quackMap.get(cl);
	}
}
