package streamreuse;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Illustrates one workaround for limitation on stream reuse -- place
//stream pipeline creation in a separate method.
public class Good {
	public static void main(String[] args) {
		Good g = new Good();
		System.out.println(g.countNumberFriendsStartingWithB("B"));
		System.out.println(g.listEditorsNamesStartingWithNUpperCase("N"));


		//by Win
		List<String> friends = Folks.friends;
		//Stream<String> streamFriends = friends.stream().filter(f->f.startsWith("B"));

		System.out.println(g.getCount(friends));
		System.out.println(g.getString(friends));
		
		BiFunction<List<String>, String, Stream<String>> bf1=(x, y)->x.stream().filter(f->f.startsWith(y));
		System.out.println(bf1.apply(Stream.of("aa","aa","cc").collect(Collectors.toList()), "aa").count());
		System.out.println(bf1.apply(Stream.of("aa","aa","cc").collect(Collectors.toList()), "aa").collect(Collectors.toList()));
	}

	int getCount(List<String> s) {
		return (int)s.stream().filter(f->f.startsWith("B")).count();
	}
	List<String> getString(List<String> s) {
		return s.stream().filter(f->f.startsWith("B")).collect(Collectors.toList());
	}
	public Stream<String> listStartsWith(List<String> list, String letter) {
		return list.stream().filter(name -> name.startsWith(letter));     	     
	}

	public int countNumberFriendsStartingWithB(String letter) {
		return (int) listStartsWith(Folks.friends, letter).count();
	}
	public List<String> listEditorsNamesStartingWithNUpperCase(String letter) {
		return listStartsWith(Folks.editors, letter).collect(Collectors.toList());
	}
}
