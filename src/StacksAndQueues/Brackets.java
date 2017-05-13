package StacksAndQueues;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class Brackets {

	private static final char OPEN_PARENTHESIS = '(';
	private static final char OPEN_BRACKET = '[';
	private static final char OPEN_BRACE = '{';
	
	private static final char CLOSE_PARENTHESIS = ')';
	private static final char CLOSE_BRACKET = ']';
	private static final char CLOSE_BRACE = '}';	
	
	public int isNested(String S) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0, size = S.length(); i < size; i++) {
			char push = S.charAt(i);
			if (push == OPEN_PARENTHESIS || push == OPEN_BRACKET || push == OPEN_BRACE) {
				stack.push(push);
			} else if (!stack.isEmpty()) {
				char pop = stack.pop();
				if (pop == OPEN_PARENTHESIS && push != CLOSE_PARENTHESIS ||
					pop == OPEN_BRACKET && push != CLOSE_BRACKET ||
					pop == OPEN_BRACE && push != CLOSE_BRACE) {
					return 0;
				}
			} else {
				return 0;
			}
		}
		
		return stack.isEmpty() ? 1 : 0;
		
	}
	
	@Test(timeout = 1000L)
	public void isNested() {
		Assert.assertEquals(1, isNested("{[()()]}"));
		Assert.assertEquals(1, isNested("{}[](){()}"));
		Assert.assertEquals(1, isNested("{[(){()}]}"));
		Assert.assertEquals(0, isNested("([)()]"));
		Assert.assertEquals(0, isNested("({[{"));
		Assert.assertEquals(0, isNested("})))"));
		Assert.assertEquals(1, isNested(""));
	}
	
}
