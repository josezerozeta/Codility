package TimeComplexity;

import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibrium {

	public int minDifference(int[] array) {
		int leftSum = 0;
		int rightSum = 0;
		int minDiff = Integer.MAX_VALUE;
		
		for (int i = 0; i < array.length; i++) {
			rightSum += array[i];
		}
		
		for (int i = 0; i < array.length - 1; i++) {
			leftSum += array[i];
			rightSum -= array[i];
			minDiff = Math.min(minDiff, Math.abs(leftSum - rightSum));
		}
		
		return minDiff;
	}
	
	@Test
	public void maxDifference() {
		Assert.assertEquals(9, minDifference(new int[] { 5, -4 }));
		Assert.assertEquals(1, minDifference(new int[] { 3, 1, 2, 4, 3 }));
		Assert.assertEquals(4, minDifference(new int[] { 5, 6, 2, 4, 1 }));
	}
}
