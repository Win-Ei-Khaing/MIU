package exercise1;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class TestLambda extends TestCase {
	@Test
	public void testLambda() {
		Customer c0 = new Customer("101", "Win", "Ei");
		c0.getCheckingAccount().updateBalance(60);
		Customer c1 = new Customer("101", "Win", "Aa");
		c1.getCheckingAccount().updateBalance(70);
		Customer c2 = new Customer("102", "Winn", "Ei");
		c2.getCheckingAccount().updateBalance(10);
		//System.out.println(CompareLibrary.compareCus(c0,  c1));
		//assert(CompareLibrary.compareCus(c1,  c0) < 0);

//		List<Account> testList=Arrays.asList(c0.getCheckingAccount(),c1.getCheckingAccount(), c2.getCheckingAccount());
//		List<Customer> expectedList=Arrays.asList(c1, c0);
//
//		List<Customer> test=Problem1.specialAccounts(testList);
//		test.forEach(System.out::println);
//		assertEquals(expectedList, test);
		
		assert(CompareLibrary.compareCus(c2,c0)==0);
	}
}
