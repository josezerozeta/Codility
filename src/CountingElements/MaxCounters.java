package CountingElements;

import org.junit.Assert;
import org.junit.Test;

public class MaxCounters {

	public int[] counter(int n, int[] array) {
		int min = 0;
		int max = 0;
		int[] result = new int[n];
		
		for (int i = 0, size = array.length; i < size; i++) {
			int coordinate = array[i] - 1;
			if (coordinate == n) {
				min =  max;
			} else {
				result[coordinate] = Math.max(min, result[coordinate]) + 1;
				max = Math.max(max, result[coordinate]);
			}
		}
		
		for (int i = 0, size = result.length; i < size; i++) {
			if (result[i] < min) {
				result[i] = min;
			}
		}
		
		return result;
	}
	
	@Test
	public void counter() {
		Assert.assertArrayEquals(
				new int[] { 2 }, 
				counter(1, new int[] { 1, 1, 2 }));
		Assert.assertArrayEquals(
				new int[] { 3, 2, 2, 4, 2 }, 
				counter(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }));
		Assert.assertArrayEquals(
				new int[] { 5, 4, 4, 4, 4 }, 
				counter(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6, 1}));
	}
	
}
