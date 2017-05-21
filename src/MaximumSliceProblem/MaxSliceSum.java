package MaximumSliceProblem;

import org.junit.Assert;
import org.junit.Test;

public class MaxSliceSum {

	public int maxSumSlice(int[] data) {
		int maxGlobal = Integer.MIN_VALUE;
		int maxLocal = 0;
		
		for (int i = 0, size = data.length; i < size; i++) {
			maxLocal += data[i];
			maxGlobal = Math.max(maxLocal, maxGlobal);
			maxLocal = Math.max(maxLocal, 0);
		}
		
		return maxGlobal;
	}
	
	@Test(timeout = 1000L)
	public void maxSumSlice() {
		Assert.assertEquals(5, maxSumSlice(new int[] { 3, 2, -6, 4, 0 }));
		Assert.assertEquals(-10, maxSumSlice(new int[] { -10 }));
		Assert.assertEquals(5, maxSumSlice(new int[] { -10, 5 }));
	}
	
}
