package PrefixSums;

import org.junit.Assert;
import org.junit.Test;

public class MinAvgTwoSlice {

	public int minAverage(int[] array) {
		
		int size = array.length;
		int pos = 0;
		
		if (size < 3) {
			return pos;
		} else {
			double sum2 = array[0] + array[1];
			double sum3 = 0; 
			double min = sum2 / 2;
		
			for (int i = 2; i < size; i++) {
				
				sum3 = sum2 + array[i];
				sum2 = sum2 - array[i-2] + array[i];
				
				double avg2 = sum2 / 2.0;
				double avg3 = sum3 / 3.0;
				
				if (avg2 < min) {
					min = avg2;
					pos = i-1;
				}
				
				if (avg3 < min) {
					min = avg3;
					pos = i-2;
				}
			}
		
			return pos;
		}
	}
	
	@Test
	public void minAverage() {
		Assert.assertEquals(
				1, 
				minAverage(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
		Assert.assertEquals(
				0, 
				minAverage(new int[] { 4, 2 }));
		Assert.assertEquals(
				2, 
				minAverage(new int[] { -3, -5, -8, -4, -10 }));
	}
	
}
