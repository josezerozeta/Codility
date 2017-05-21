package MaximumSliceProblem;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfit {

	public int maxProfit(int[] price) {
		int maxGlobal = 0;
		int maxLocal = 0;
		
		for (int i = 1, days = price.length; i < days; i++) {
			maxLocal += price[i] - price[i-1];
			maxLocal = Math.max(maxLocal, 0);
			maxGlobal = Math.max(maxLocal, maxGlobal);
		}
		
		return maxGlobal;
	}
	
	@Test(timeout = 1000L)
	public void maxProfit() {
		Assert.assertEquals(
				356,
				maxProfit(new int[] { 23171, 21011, 21123, 21366, 21013, 21367 }));
	}
	
}
