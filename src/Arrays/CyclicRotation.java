package Arrays;

import org.junit.Assert;
import org.junit.Test;

public class CyclicRotation {

	public int[] rotate(int[] array, int k){
		int size = array.length;
		
		if (size == 0 || k % size == 0) {
			return array;
		} else {
			int[] rotatedArray = new int[size];
			
			for (int i = 0; i < size; i++) {
				rotatedArray[(i + k) % size] = array[i];
			}
		
			return rotatedArray;
		}
	}
	
	@Test
	public void rotate() {
		int[] array = new int[] { 1, 2, 3 };
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, rotate(array, 0));
 		Assert.assertArrayEquals(new int[] { 3, 1, 2 }, rotate(array, 1));
 		Assert.assertArrayEquals(new int[] { 2, 3, 1 }, rotate(array, 2));
 		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, rotate(array, 3));
 		Assert.assertArrayEquals(new int[] { 3, 1, 2 }, rotate(array, 4));
 		
 		int[] empty = new int[0];
 		Assert.assertArrayEquals(empty, rotate(empty, 4));
	}
	
}
