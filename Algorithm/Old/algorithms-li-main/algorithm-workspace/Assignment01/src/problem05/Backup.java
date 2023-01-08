package problem05;

import java.util.Arrays;
import java.util.List;

// A recursive solution for subset sum
// problem
class Backup {

	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum(List<Integer> set,
							int n, int sum)
	{
		List<Integer> list;
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (set.get(n - 1) > sum)
			return isSubsetSum(set, n - 1, sum);

		/* else, check if sum can be obtained
		by any of the following
			(a) including the last element
			(b) excluding the last element */
		return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set.get(n - 1));
	}

	/* Driver program to test above function */
	public static void main(String args[])
	{
		List<Integer> set = Arrays.asList(3,34,4,12,5,2);
		Integer sum = 9;
		int n = set.size();
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset"
							+ " with given sum");
		else
			System.out.println("No subset with"
							+ " given sum");
	}
}