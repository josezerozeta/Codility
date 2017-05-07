package PrefixSums;

import org.junit.Assert;
import org.junit.Test;


public class CountDiv {

	public int countDiv(int a, int b, int k) {
		int min = a % k == 0 ? a/k : (a/k + 1);
		int max = b / k;
		return max - min + 1;
	}
	
	@Test
	public void countDiv() {
		Assert.assertEquals(4, countDiv(5, 12, 2));
		Assert.assertEquals(3, countDiv(6, 11, 2));
		Assert.assertEquals(4, countDiv(6, 12, 2));
		Assert.assertEquals(3, countDiv(5, 11, 2));
		Assert.assertEquals(1, countDiv(12, 12, 2));
		Assert.assertEquals(0, countDiv(11, 11, 2));
		Assert.assertEquals(0, countDiv(5, 11, 200));
	}

}
