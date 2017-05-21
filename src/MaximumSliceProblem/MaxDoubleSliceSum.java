package MaximumSliceProblem;

import org.junit.Assert;
import org.junit.Test;

public class MaxDoubleSliceSum {

	// There is a problem on this exercise and it need to be fixed
	// Performance test : large_sequence (error output)
	// Total points : 92 %
	public int maxDoubleSumSlice(int[] data) {
		int min = Integer.MAX_VALUE;
		int maxGlobal = Integer.MIN_VALUE;
		int maxLocal = 0;
		
		for (int i = 1, size = data.length - 1; i < size; i++) {
			maxLocal += data[i];
			min = Math.min(min, data[i]);
			maxGlobal = Math.max(maxLocal - min, maxGlobal);
			if (maxLocal < 0) {
				min = Integer.MAX_VALUE;
				maxLocal = 0;
			}
		}
		
		min = Integer.MAX_VALUE;
		maxLocal = 0;
		for (int i = data.length - 2; 0 < i; i--) {
			maxLocal += data[i];
			min = Math.min(min, data[i]);
			maxGlobal = Math.max(maxLocal - min, maxGlobal);
			if (maxLocal < 0) {
				min = Integer.MAX_VALUE;
				maxLocal = 0;
			}
		}
		
		return maxGlobal;
	}
	
	@Test(timeout = 1000L)
	public void maxDoubleSumSlice() {
		Assert.assertEquals(
				17,
				maxDoubleSumSlice(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
		Assert.assertEquals(
				6,
				maxDoubleSumSlice(new int[] { -3, -2, 6, -1, -1 }));
		Assert.assertEquals(
				6,
				maxDoubleSumSlice(new int[] { -3, -2, 6, -1 }));
		Assert.assertEquals(
				8,
				maxDoubleSumSlice(new int[] { 3, 2, 6, -10, 5 }));
		Assert.assertEquals(
				32,
				maxDoubleSumSlice(new int[] { 3, 2, 6, -10, 5, -10, 20, 7, 0 }));
	}
	
}
