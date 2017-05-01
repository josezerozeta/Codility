package Arrays;

import org.junit.Assert;
import org.junit.Test;

public class OddOccurrencesInArray {

	public int findOdd(int array[]) {
		int result = 0;
		
		for (int i = 0; i < array.length; i++) {
			result ^= array[i];
		}
		
		return result;
	}
	
	@Test
	public void findOdd() {
		Assert.assertEquals(0, findOdd(new int[] { 0 }));
		Assert.assertEquals(0, findOdd(new int[] { 1, 0, 1 }));
		Assert.assertEquals(0, findOdd(new int[] { 2, 2, 0, 0, 0, 2, 2 }));
		Assert.assertEquals(2, findOdd(new int[] { 2, 2, 2 }));
	}
}
