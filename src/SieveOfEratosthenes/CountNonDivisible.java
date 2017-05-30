package SieveOfEratosthenes;

import org.junit.Assert;
import org.junit.Test;

public class CountNonDivisible {

	public int[] countNonDivisible(int[] data) {

		int size = data.length;
		
		int[] values = new int[2*size];	
		for (int i = 0; i < size; i++) {
			values[data[i]-1]++;
		}

		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			int target = data[i];
			result[i] = size;
			int sqrt = (int) Math.sqrt(target);
			for (int d = 1; d <= sqrt; d++) {
				if (target % d == 0) {
					result[i] -= values[d - 1];
					if (target/d != d) {
						result[i] -= values[target / d - 1];
					}
				}
			}
		}

		return result;
	}

	@Test(timeout = 10000000L)
	public void correctness() {
		Assert.assertArrayEquals(
				new int[] { 2, 4, 3, 2, 0 }, 
				countNonDivisible(new int[]{ 3, 1, 2, 3, 6 }));
		Assert.assertArrayEquals(
				new int[] { 1, 0 }, 
				countNonDivisible(new int[]{ 2, 4 }));
		Assert.assertArrayEquals(
				new int[] { 4, 6, 6, 4, 6, 6, 4 }, 
				countNonDivisible(new int[]{ 2, 3, 5, 2, 7, 11, 2 }));
	}

}
