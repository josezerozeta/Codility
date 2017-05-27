package Iterations;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGap {

	public int maxGap(int number) {
		int maxGap = 0;

		int mask = number & -number;
		int from = Integer.bitCount(mask-1);
		
		int to = 0;
		while (number != 0) {
			to = Integer.bitCount(mask-1);
			maxGap = Math.max(maxGap, to-from-1);
			from = to;
			number &= ~mask;
			mask = number & -number;
		}
		
		return maxGap;
	}
	
	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertEquals(0, maxGap(0));
		Assert.assertEquals(2, maxGap(9));
		Assert.assertEquals(0, maxGap(15));
		Assert.assertEquals(1, maxGap(20));
		Assert.assertEquals(0, maxGap(64));
		Assert.assertEquals(2, maxGap(79));
		Assert.assertEquals(4, maxGap(529));
		Assert.assertEquals(5, maxGap(1041));
		Assert.assertEquals(0, maxGap(Integer.MAX_VALUE));
	}
	
}
