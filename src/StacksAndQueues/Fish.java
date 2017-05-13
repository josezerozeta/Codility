package StacksAndQueues;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class Fish {

	private static final int UPSTREAM = 0;
	private static final int DOWNSTREAM = 1;
	
	public int survivors(int[] size, int[] direction) {
		
		int numFish = size.length;
		Stack<Integer> fishes = new Stack<>(); 
		
		for (int actual = 0; actual < numFish; actual++) {
			if (fishes.empty()) {
				fishes.push(actual);
			} else {
				int old;
				boolean fight;
				boolean eaten;
				
				do {
					old = fishes.pop().intValue();
					fight = direction[old] == DOWNSTREAM && direction[actual] == UPSTREAM;
					eaten = size[old] < size[actual];
				} while (fight && eaten && !fishes.empty());
				
				if (fight) {
					fishes.push(eaten ? actual : old);
				} else {
					fishes.push(old);
					fishes.push(actual);
				}
			}
		}
		
		return fishes.size();
	}
	
	@Test(timeout = 1000L)
	public void survivors() {
		int[] fishes = new int[] { 4, 3, 2, 1, 5 };
		
		Assert.assertEquals(2, survivors(fishes, new int[] { 0, 1, 0, 0, 0 }));
		Assert.assertEquals(5, survivors(fishes, new int[] { 0, 0, 0, 0, 0 }));
		Assert.assertEquals(5, survivors(fishes, new int[] { 1, 1, 1, 1, 1 }));
		Assert.assertEquals(4, survivors(fishes, new int[] { 1, 0, 1, 1, 1 }));
		Assert.assertEquals(1, survivors(fishes, new int[] { 1, 1, 1, 1, 0 }));
		Assert.assertEquals(2, survivors(fishes, new int[] { 0, 1, 1, 1, 0 }));
	}
}
