package Sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Distinct {

	public int find(int[] array) {
		Arrays.sort(array);
		int actual = Integer.MAX_VALUE;
		int count = 0;
		
		for (int i = 0, size = array.length; i < size; i++) {
			int value =  array[i];
			if (actual != value) {
				actual = value;
				count++;
			}
		}
		
		return count;
	}
	
	@Test
	public void find() {
		Assert.assertEquals(3, find(new int[] { 2, 1, 1, 2, 3, 1 }));
		Assert.assertEquals(0, find(new int[] { }));
		Assert.assertEquals(1, find(new int[] { 2, 2, 2 }));
		Assert.assertEquals(3, find(new int[] { 1, 2, 4 }));
	}
	
}
