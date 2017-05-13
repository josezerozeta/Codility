package StacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

public class Nesting {

	private static final char OPEN_PARENTHESIS = '(';
	
	public int isNested(String S) {
		
		int count = 0;
		for (int i = 0, size = S.length(); i < size; i++) {
			if (S.charAt(i) == OPEN_PARENTHESIS) {
				count++;
			} else if (count != 0) {
				count--;
			} else {
				return 0;
			}
		}
		return count == 0 ? 1 : 0;
	}
	
	@Test(timeout = 1000L)
	public void isNested() {
		Assert.assertEquals(1, isNested("(()(())())"));
		Assert.assertEquals(0, isNested("(((("));
		Assert.assertEquals(0, isNested("))))"));
		Assert.assertEquals(0, isNested("())"));
		Assert.assertEquals(1, isNested("()()"));
	}
	
}
