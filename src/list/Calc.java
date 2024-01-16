package list;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class Calc {

	@Test
	public void add()
	{
		int a=10;
		int b=20;
		int c=a+b;
		Assert.assertEquals(c,30);
	}
	@Test
	public void compare()
	{
		Assert.assertEquals(10, 20);
		
	}
}
