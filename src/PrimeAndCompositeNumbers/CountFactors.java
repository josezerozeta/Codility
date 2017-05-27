package PrimeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

public class CountFactors {

	public int countFactors(int N) {
		int count = 0;
		double root = Math.sqrt(N);
		
		int i = 1;
		while (i < root) {
			if (N % i == 0) {
				count += 2;
			}
			i++;
		}
		
		if (i == root) {
			count++;
		}
		
		return count;
	}
	
	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertEquals(3, countFactors(25));
		Assert.assertEquals(8, countFactors(24));
		Assert.assertEquals(1, countFactors(1));
	}
	
}
