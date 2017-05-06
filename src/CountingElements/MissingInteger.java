package CountingElements;

import org.junit.Assert;
import org.junit.Test;

public class MissingInteger {

	public int findMissing(int[] array) {
		int size = array.length;
		boolean[] flags = new boolean[size];
		
		for (int i = 0; i < size; i++) {
			int coordinate = array[i] - 1;
			if (coordinate > -1 && coordinate < size) {
				flags[coordinate] = true;
			}
		}
		
		for (int coordinate = 0; coordinate < size; coordinate++) {
			if (!flags[coordinate]) {
				return coordinate + 1;
			}
		}
		
		return size + 1;
	}
	
	@Test
	public void findMissing() {
		Assert.assertEquals(2, findMissing(new int[] { 1 }));
		Assert.assertEquals(1, findMissing(new int[] { 2 }));
		Assert.assertEquals(4, findMissing(new int[] { 1, 2, 3 }));
		Assert.assertEquals(1, findMissing(new int[] { -1, -3, -6, -4, -1, -2 }));
		Assert.assertEquals(3, findMissing(new int[] { 1, -3, -6, -4, -3, 2 }));
		Assert.assertEquals(5, findMissing(new int[] { 1, 3, 6, 4, -3, 2 }));
		Assert.assertEquals(5, findMissing(new int[] { 1, 3, 6, 4, 1, 2 }));
		Assert.assertEquals(5, findMissing(new int[] { 1, 3, 6, 4, Integer.MAX_VALUE, 2 }));
	}
	
}
