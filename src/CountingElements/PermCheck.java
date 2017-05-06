/**
 * 
 */
package CountingElements;

import org.junit.Assert;
import org.junit.Test;

public class PermCheck {

	public int checkPerm(int[] array) {
		int size = array.length;
		int count = 0;
		boolean[] flags = new boolean[size];
		
		for (int i = 0; i < size; i++) {
			int coordinate = array[i] - 1;
			if (coordinate < size && !flags[coordinate]) {
				count++;
				flags[coordinate] = true;
			}
		}
		
		return count == size ? 1 : 0;
	}
	
	@Test
	public void findMissingValue() {
		Assert.assertEquals(1, checkPerm(new int[] { 1 }));
		Assert.assertEquals(0, checkPerm(new int[] { 1, 1 }));
		Assert.assertEquals(0, checkPerm(new int[] { 3, 1 }));
		Assert.assertEquals(0, checkPerm(new int[] { 1, 4, 1 }));
		Assert.assertEquals(1, checkPerm(new int[] { 1, 2, 4, 3 }));
	}
	
	
}
