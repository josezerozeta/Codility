package PrimeAndCompositeNumbers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Flags {

	public int flags(int[] data) {
		int size = data.length;
		List<Integer> peaks = new ArrayList<>();
		
		for (int i = 1; i < size-1; i++) {
			if (data[i-1] < data[i] && data[i+1] < data[i]) {
				peaks.add(i);
			}
		}
		
		if (peaks.isEmpty()) {
			return 0;
		}
		
		int numFlags = 0;
		int maxFlags = (int) Math.sqrt(size) + 1;
		int numPeaks = peaks.size();
		for (int flags = maxFlags; 0 < flags; flags--) {
			int count = 1;
			int from = peaks.get(0);
			int i = 1;
			while (i < numPeaks) {
				if (count != flags) {
					int peak = peaks.get(i);
					if (count != flags && peak - from >= flags) {
						from = peaks.get(i);
						count++;
					}
				} else {
					break;
				}
				i++;
			}
			if (count == flags) {
				numFlags = flags;
				break;
			}
		}
		
		return numFlags;
	}
	
	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertEquals(
				1,
				flags(new int[] { 1, 3, 2 }));
		Assert.assertEquals(
				0,
				flags(new int[] { 1, 2, 3, 4, 5 }));
		Assert.assertEquals(
				1,
				flags(new int[] { 1, 2, 7, 4, 5 }));
		Assert.assertEquals(
				0,
				flags(new int[] { 1 }));
		Assert.assertEquals(
				3,
				flags(new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
		Assert.assertEquals(
				4,
				flags(new int[] { 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 1 }));
	}
}
