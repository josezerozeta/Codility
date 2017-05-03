package TimeComplexity;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElem {

	public int findMissingValue(int[] array) {
		int size = array.length;
		
		long sum = 0;
		long expected = (size + 1L) * (size + 2L) / 2L;
		
		for (int i = 0; i < size; i++) {
			sum += array[i];
		}
		
		return (int) (expected - sum);
	}
	
	@Test
	public void findMissingValue() {
		Assert.assertEquals(2, findMissingValue(new int[] { 1 }));
		Assert.assertEquals(1, findMissingValue(new int[] { 2, 3 }));
		Assert.assertEquals(3, findMissingValue(new int[] { 1, 2, 4 }));
		Assert.assertEquals(3, findMissingValue(new int[] { 1, 2, 4, 5 }));
	}
	
}
