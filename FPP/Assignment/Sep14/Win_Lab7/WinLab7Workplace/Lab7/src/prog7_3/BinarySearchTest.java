package prog7_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
@Test
	public void test() {
	boolean result1=BinarySearch.search("abcdefghijklmnopqrs", 'i');
	assertEquals(true, result1);
	
	boolean result2=BinarySearch.search("turvwxyz", 'i');
	assertEquals(false, result2);
}
}
