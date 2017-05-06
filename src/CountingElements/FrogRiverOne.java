package CountingElements;

import org.junit.Assert;
import org.junit.Test;

public class FrogRiverOne {

	public int getTime(int position, int[] array) {
		int count = 0;
		boolean[] steps = new boolean[position];
		
		for (int time = 0, size = array.length; time < size; time++) {
			int coordinate = array[time] - 1;
			if (coordinate < position && !steps[coordinate]) {
				steps[coordinate] = true;
				count++;
				if (count == position) {
					return time;
				}
			}
		}
		
		return -1;
	}
	
	@Test
	public void findMissingValue() {
		Assert.assertEquals(6, getTime(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		Assert.assertEquals(7, getTime(5, new int[] { 1, 3, 1, 4, 2, 7, 3, 5, 4 }));
		Assert.assertEquals(-1, getTime(6, new int[] { 1, 3, 1, 4, 2, 7, 3, 5, 4 }));
		Assert.assertEquals(-1, getTime(6, new int[] { 1, 3, 1, 4, 3, 5, 4 }));
		Assert.assertEquals(4, getTime(4, new int[] { 1, 3, 8, 4, 2, 5, 4 }));
	}
	
}
