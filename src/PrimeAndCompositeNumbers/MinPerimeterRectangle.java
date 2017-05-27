package PrimeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

public class MinPerimeterRectangle {

	public int minPerimeter(int area) {
		int perimeter = Integer.MAX_VALUE;
		
		int i = 1;
		while (i*i < area) {
			if (area % i == 0) {
				perimeter = Math.min(perimeter, (i + area/i) << 1);
			}
			i++;
		}
		
		if (i*i == area) {
			perimeter = Math.min(perimeter, i << 2);
		}
		
		return perimeter;
	}
	
	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertEquals(22, minPerimeter(30));
		Assert.assertEquals(20, minPerimeter(25));
		Assert.assertEquals(4, minPerimeter(1));
	}
	
}
