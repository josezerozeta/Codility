package StacksAndQueues;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class StoneWall {

	public int minBlocks(int[] height) {
		int count = 0;
		int h = 0;
		Stack<Integer> blocks = new Stack<>();
		
		for (int i = 0, size = height.length; i < size; i++) {
			int actual = height[i];
			if (blocks.empty()) {
				h += actual;
				blocks.push(actual);
			} else {
				while (h > actual) {
					count++;
					h -= blocks.pop();
				}
				if (h < actual) {
					blocks.push(actual-h);
					h = actual; 
				}
			}
		}
		
		return count + blocks.size();
	}
	
	@Test(timeout = 1000L)
	public void blocks() {
		Assert.assertEquals(0, minBlocks(new int[] { }));
		Assert.assertEquals(
				7,
				minBlocks(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }));
		Assert.assertEquals(
				9,
				minBlocks(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
		Assert.assertEquals(
				9,
				minBlocks(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }));
		Assert.assertEquals(
				1,
				minBlocks(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
	}
	
}
