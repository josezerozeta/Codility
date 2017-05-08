package Sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Triangle {

	public int triangular(int[] array) {
		int size = array.length;
		
		if (size < 3) {
			return 0;
		}
		
		Arrays.sort(array);
		
		for (int i = 0, limit = size-2; i < limit; i++) {
			long delta = (long) array[i] + (long) array[i+1] - (long) array[i+2];
			if (delta > 0L) {
				return 1;
			}
		}
		
		return 0;
	}
	
	@Test
	public void triangular() {
		Assert.assertEquals(0, triangular(new int[] { 1 }));
		Assert.assertEquals(1, triangular(new int[] { 3, 4, 5 }));
		Assert.assertEquals(0, triangular(new int[] { 12, 1, 4 }));
		Assert.assertEquals(1, triangular(new int[] { 10, 2, 5, 1, 8, 20 }));
		Assert.assertEquals(0, triangular(new int[] { 10, 50, 5, 1 }));
		Assert.assertEquals(1, triangular(new int[] { 6, 6, 6, 6 }));
		Assert.assertEquals(0, triangular(new int[] { 0, 0, 0, 0 }));
	}
}
