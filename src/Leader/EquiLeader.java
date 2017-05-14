package Leader;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class EquiLeader {

	public int countEquiLeader(int[] data) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0, size = data.length; i < size; i++) {
			int actual = data[i];
			if (stack.isEmpty()) {
				stack.push(actual);
			} else if (actual == stack.peek()) {
				stack.push(actual);
			} else {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			return 0;
		}
		
		int numOfLeaders = 0;
		int count = 0;
		int numOfEquiLeaders = 0;
		int leader = stack.pop();
		
		for (int i = 0, size = data.length; i < size; i++) {
			if (data[i] == leader) {
				numOfLeaders++;
			}
		}
		
		for (int i = 0, size = data.length; i < size; i++) {
			if (data[i] == leader) {
				count++;
			}
			if ((i+1) / 2 < count && (size-i-1) / 2 < (numOfLeaders - count)) {
				numOfEquiLeaders++;
			}
		}
		
		return numOfEquiLeaders;
	}
	
	@Test(timeout = 1000L)
	public void countEquiLeader() {
		Assert.assertEquals(0, countEquiLeader(new int[] { 1, 2 }));
		Assert.assertEquals(2, countEquiLeader(new int[] { 4, 3, 4, 4, 4, 2 }));
		Assert.assertEquals(4, countEquiLeader(new int[] { 4, 4, 4, 4, 4 }));
	}
	
}
