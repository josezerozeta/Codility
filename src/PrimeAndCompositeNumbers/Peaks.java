package PrimeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

public class Peaks {

	public int peaks(int[] data) {
		int size = data.length;
		int[] peaks = new int[size];
		int numPeaks = 0;
		
		for (int i = 1; i < size-1; i++) {
			if (data[i-1] < data[i] && data[i+1] < data[i]) {
				peaks[i] = peaks[i-1] + 1;
				numPeaks++;
			} else {
				peaks[i] = peaks[i-1];
			}
		}
		peaks[size-1] = numPeaks;
		
		int partition = 0;
		for (int numBlocks = 1; numBlocks < size; numBlocks++) {
			if (size % numBlocks == 0) {
				int count = 0;
				int blockSize = size / numBlocks;
				int block = 0;
				while (block < numBlocks) {
					int from = block * blockSize;
					int to = from + blockSize;
					if (peaks[to-1] - peaks[from == 0 ? 0 : from-1] > 0) {
						count++;
						block++;
					} else {
						break;
					}
				}
				partition = count == numBlocks ? numBlocks : partition;
			}
		}
		
		return partition;
	}
	
	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertEquals(
				3,
				peaks(new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
		Assert.assertEquals(
				0,
				peaks(new int[] { 1, 2, 3, 4 }));
		Assert.assertEquals(
				1,
				peaks(new int[] { 1, 6, 3, 4 }));
		Assert.assertEquals(
				3,
				peaks(new int[] { 1, 6, 3, 1, 6, 3, 1, 6, 3 }));
		Assert.assertEquals(
				2,
				peaks(new int[] { 1, 6, 3, 4, 1, 1 }));
	}
}
