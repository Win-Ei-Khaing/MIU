package Final.prob4.exam;

import java.util.function.Function;

@FunctionalInterface
public interface Win<T,R> {
	R apply(T t) throws Exception;

	public static <T,R> Function<T,R> cc(FunctionWithException<T,R> f) {
		return x -> {	
			try {
				return f.apply(x);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

}