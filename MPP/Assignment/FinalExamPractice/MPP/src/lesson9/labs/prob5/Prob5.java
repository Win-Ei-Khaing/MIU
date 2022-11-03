package lesson9.labs.prob5;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prob5 {

	public static void main(String[] args) {
		Stream<String> words = Stream.of("gently", "down", "the", "stream",
				"Wild", "white", "horses", "Through", "the", "glory", "of",
				"life");
		Stream<String> wordsSection = streamSection(words, 4, 7);
		System.out.println(wordsSection.collect(Collectors.toList()));
	}

	private static Stream<String> streamSection(Stream<String> stream, int m,
			int n) {
		return stream.skip(m).limit(n - m);
	}
}
