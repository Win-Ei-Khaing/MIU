package flatmapstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Shows how flatMap works and also shows that
 *      flatMap = map followed by default flatMap
 */
public class Test {
	public static void main(String[] args) {
		List<String> l = Arrays.asList("Bob", "Joe");
		Stream<List<Character>> a = l.stream()
									.map(x->stringToCharStream(x).collect(Collectors.toList()));
		System.out.println(a.collect(Collectors.toList()));
		//System.out.println(l.stream()
		//		.map(x->stringToCharStream(x).collect(Collectors.toList()))
		//		.collect(Collectors.toList()));
		
		//usual way
		System.out.println(l.stream()
				            .flatMap(x -> stringToCharStream(x))
				            .collect(Collectors.toList()));
		
		//this is the same as composing map with default flatMap
		System.out.println(l.stream()
				            .map(x -> stringToCharStream(x)) //produces a stream of streams
				            .flatMap((Stream<Character> st) -> st) //flattens to a single stream
				            .collect(Collectors.toList()));
		
	}
	
	static Stream<Character> stringToCharStream(String s) {
		char[] chars = s.toCharArray();
		Character[] chs = new Character[s.length()];
		for(int i = 0; i < s.length(); ++i) {
			chs[i] = chars[i];
		}
		return Stream.of(chs);
	}
}
