package TimeComplexity;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElem {

	public int findMissingValue(int[] data) {
		int size = data.length;
		int missing = 0;
		
		for (int i = 0; i < size; i++) {
			missing ^= (data[i] ^ (i+1));
		}
		
		return missing ^ (size+1);
	}
	
	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertEquals(2, findMissingValue(new int[] { 1 }));
		Assert.assertEquals(1, findMissingValue(new int[] { 2, 3 }));
		Assert.assertEquals(3, findMissingValue(new int[] { 1, 2, 4 }));
		Assert.assertEquals(3, findMissingValue(new int[] { 1, 2, 4, 5 }));
	}
	
}
