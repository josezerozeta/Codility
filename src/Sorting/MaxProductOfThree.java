package Sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductOfThree {

	public int maxProductOfThree(int[] array) {
		
		Arrays.sort(array);
		int size = array.length;
		int product = 
				Math.max(
						array[0]*array[1]*array[2], 
						array[size-3]*array[size-2]*array[size-1]);
		
		return product;
	}
	
	@Test
	public void maxProductOfThree() {
		Assert.assertEquals(
				60,
				maxProductOfThree(new int[] { -3, 1, 2, -2, 5, 6}));
		Assert.assertEquals(
				80,
				maxProductOfThree(new int[] { -40, 1, -2, 2, 5, 6}));
	}
	
}
