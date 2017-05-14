package Leader;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Dominator {

	public int indexDominator(int[] data) {
		int count = 0;
		int index = -1;
		int leader = 0;
		int size = data.length;
		
		for (int i = 0; i < size; i++) {
			int actual = data[i];
			if (count == 0) {
				leader = actual;
				index = i;
				count++;
			} else if (actual == leader) {
				count++;
			} else if (count > 0) {
				count--;
			}
		}
		
		if (count > 0) {
			int num = 0;
			for (int i = 0; i < size; i++) {
				if (leader == data[i]) {
					num++;
				}
			}
			return num > size /2 ? index : -1;
		} else {
			return -1;
		}
	}
	
	@Test(timeout = 1000000L)
	public void indexDominator() {
		Assert.assertEquals(-1, indexDominator(new int[] { 1, 2, 3, 4 }));
		Assert.assertEquals(-1, indexDominator(new int[] { 1, 2, 3, 4, 5 }));
		Assert.assertTrue(
				Arrays.asList(0, 2, 4, 6, 7).contains(
						indexDominator(new int[] { 3, 4, 3, 2, 3, -1, 3, 3 })));
	}
}
