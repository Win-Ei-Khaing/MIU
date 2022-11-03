package lesson10.labs.prob7.soln2;

import org.junit.Assert;
import org.junit.Test;

public class Test2 {
	@Test
	public void salaryGreaterThan100000() {
		Employee emp1 = new Employee("Joe", "Davis", 120000);
		Assert.assertEquals(true, Main.salaryGreaterThan100000(emp1));

		Employee emp2 = new Employee("Andrew", "Reardon", 80000);
		Assert.assertEquals(false, Main.salaryGreaterThan100000(emp2));
	}

	@Test
	public void lastNameLargerThanM() {
		Employee emp1 = new Employee("Joe", "Davis", 120000);
		Assert.assertEquals(false, Main.lastNameLargerThanM(emp1));

		Employee emp2 = new Employee("Andrew", "Reardon", 80000);
		Assert.assertEquals(true, Main.lastNameLargerThanM(emp2));
	}

	@Test
	public void fullName() {
		Employee emp1 = new Employee("Joe", "Davis", 120000);
		Assert.assertEquals("Joe Davis", Main.fullName(emp1));

		Employee emp2 = new Employee("Andrew", "Reardon", 80000);
		Assert.assertEquals("Andrew Reardon", Main.fullName(emp2));
	}
}
