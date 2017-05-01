package Iterations;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGap {

	public int maxGap(int N) {
		int maxGap = 0;
		
		int gap = 0;
		int mask = N & ~(N-1);
		
		while (N != 0) {
			N &= ~mask;
			mask <<=1;
			
			if ((N & mask) == 0) {
				gap++;
			} else {
				maxGap = Math.max(maxGap, gap);
				gap = 0;
			}
			
		}
		
		return maxGap;
	}
	
	@Test
	public void test() {
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
