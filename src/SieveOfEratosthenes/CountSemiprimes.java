package SieveOfEratosthenes;

import org.junit.Assert;
import org.junit.Test;

public class CountSemiprimes {

	public int[] countSemiprimes(int n, int[] start, int[] end) {
		int[] sieve = new int[n];

		int size = start.length;
		int[] result = new int[size];

		int i = 2;
		int sqrt = (int) Math.sqrt(n);

		while (i <= sqrt) {
			if (sieve[i-1] == 0) {
				int k = i*i;
				while (k <= n) {
					if (sieve[k-1] == 0) {
						sieve[k-1] = i;
					}
					k += i;
				}
			}
			i++;
		}

		int[] semiprimes = new int[n];
		for (int index = 1; index < n; index++) {
			semiprimes[index] = semiprimes[index-1];
			if (sieve[index] != 0 && sieve[(index+1) / sieve[index] - 1] == 0) {
				semiprimes[index]++;
			}
		}

		for (int query = 0; query < size; query++) {
			int from = start[query];
			int to = end[query];
			result[query] = semiprimes[to-1] - semiprimes[from == 1 ? 0 : from-2];
		}

		return result;
	}

	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertArrayEquals(
				new int[] { 10, 4, 0 }, 
				countSemiprimes(
						26, 
						new int[]{ 1, 4, 16 }, 
						new int[]{ 26, 10, 20 }));
	}
	
}
