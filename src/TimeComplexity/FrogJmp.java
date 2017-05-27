package TimeComplexity;

import org.junit.Assert;
import org.junit.Test;

public class FrogJmp {

	public int jumps(int X, int Y, int D) {
		int steps = (Y - X) / D;
		return (Y - X) % D == 0 ? steps : steps + 1;
	}
	
	@Test(timeout = 1000L)
	public void correctness() {
		Assert.assertEquals(0, jumps(10, 10, 30));
		Assert.assertEquals(2, jumps(10, 70, 30));
		Assert.assertEquals(3, jumps(10, 80, 30));
	}
}
