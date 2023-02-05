package lesson1.exercise_2.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import lesson1.exercise_2.program.Address;

public class TestAddress {
	/** Test that formatted string representation of address is correct */
	@Test
	public void testToString() {
		Address addr = new Address("10 Adams", "Fairfield", "IA", "52556");
		assertEquals("String version of address not formatted properly",
				"10 Adams, Fairfield, IA 52556",
				addr.toString());
		
	}
}
