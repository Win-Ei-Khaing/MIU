package prob3;

import java.util.function.Function;

//implemented by Win

@FunctionalInterface
public interface FunctionWithException<T, R> {
	R apply(T t) throws Exception;
	
	public static <T,R> Function<T,R> unchecked(FunctionWithException<T,R> f) {
		return x -> {	
			try {
				return f.apply(x);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
