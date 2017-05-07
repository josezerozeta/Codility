package PrefixSums;

import org.junit.Assert;
import org.junit.Test;

public class ParsingCars {

	private static final int EAST = 1;
	
	public int parsingCars(int[] array) {
		
		int add = 0;
		int count = 0;
		
		for (int i = 0, size = array.length; i < size; i++) {
			if (array[i] == EAST) {
				count += add;
			} else {
				add++;
			}
		}
		
		return count > 1_000_000_000 || count < 0 ? -1 : count;
	}
	
	@Test
	public void parsingCars() {
		Assert.assertEquals(
				5, 
				parsingCars(new int[] { 0, 1, 0, 1, 1 }));
		Assert.assertEquals(
				8, 
				parsingCars(new int[] { 0, 0, 1, 0, 1, 1 }));
		Assert.assertEquals(
				0, 
				parsingCars(new int[] { 0, 0, 0, 0, 0, 0 }));
		Assert.assertEquals(
				0, 
				parsingCars(new int[] { 1, 0, 0, 0, 0, 0 }));
		Assert.assertEquals(
				0, 
				parsingCars(new int[] { 1, 1, 1, 1, 1, 0 }));
	}
	
}
