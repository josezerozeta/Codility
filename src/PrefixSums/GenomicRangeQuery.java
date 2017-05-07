package PrefixSums;

import org.junit.Assert;
import org.junit.Test;

public class GenomicRangeQuery {

	private static final char A = 'A';
	private static final char C = 'C';
	private static final char G = 'G';
	private static final char T = 'T';
	
	public int[] minImpact(String adn, int[] from, int[] to) {
		
		int size = adn.length();
		
		int[] A = new int[size];
		int[] C = new int[size];
		int[] G = new int[size];
		int[] T = new int[size];
		
		for (int i = 0; i < size; i++) {
			char code = adn.charAt(i);
			int coordinate = (i-1) < 0 ? 0: i-1; 
			A[i] = code == GenomicRangeQuery.A ? A[coordinate] + 1 : A[coordinate];
			C[i] = code == GenomicRangeQuery.C ? C[coordinate] + 1 : C[coordinate];
			G[i] = code == GenomicRangeQuery.G ? G[coordinate] + 1 : G[coordinate];
			T[i] = code == GenomicRangeQuery.T ? T[coordinate] + 1 : T[coordinate]; 
		}
		
		int queries = from.length;
		int[] result = new int[queries];
		
		for (int query = 0; query < queries; query++) {
			int start = from[query] == 0 ? 0 : from[query]-1;
			int end = to[query];
			
			if (A[end] - A[start] > 0 || end == 0 && A[start] > 0) {
				result[query] = 1;
			} else if (C[end] - C[start] > 0 || end == 0 && C[start] > 0) {
				result[query] = 2;
			} else if (G[end] - G[start] > 0 || end == 0 && G[start] > 0) {
				result[query] = 3;
			} else if (T[end] - T[start] > 0 || end == 0 && T[start] > 0) {
				result[query] = 4;
			}
 		}
		
		return result;
	}
	
	@Test
	public void minImpact() {
		Assert.assertArrayEquals(
				new int[] { 2, 4, 1, 2, 1 }, 
				minImpact(
						"CAGCCTA", 
						new int[] { 2, 5, 0, 0, 6 }, 
						new int[] { 4, 5, 6, 0, 6 }));
	}
	
}
