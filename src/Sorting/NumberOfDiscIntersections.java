package Sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfDiscIntersections {

	public int numberOfIntersections(int[] radius) {
		int size = radius.length;
		long intersections = 0;
		
		long[] lower = new long[size];
		long[] upper = new long[size];
		
		for (int i = 0; i < size; i++) {
			lower[i] = (long) i - (long) radius[i];
			upper[i] = (long) i + (long) radius[i];
		}
		
		Arrays.sort(lower);
		Arrays.sort(upper);
		
		for (int i = 0; i < size; i++) {
			long value = lower[i];
			int index = Arrays.binarySearch(upper, value);
			if (index < 0) {
				intersections += (size - ~index);
			} else {
				while (index > 0 && value == upper[index-1]) {
					index--;
				}
				intersections += (size - index);
			}
		}
		
		intersections -= (size + 1L) * size / 2L; 
		
		return intersections > 10_000_000L ? -1 : (int) intersections;
	}
	
	@Test
	public void numberOfIntersections() {
		
		Assert.assertEquals(
				11, 
				numberOfIntersections(new int[] { 1, 5, 2, 1, 4, 0 }));
		Assert.assertEquals(
				6, 
				numberOfIntersections(new int[] { 1, 0, 1, 0, 1 }));
	}
	
}
