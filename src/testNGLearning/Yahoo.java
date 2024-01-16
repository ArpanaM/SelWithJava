package testNGLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Yahoo {
	WebDriver driver;
	@Test(description="Launch",priority=1)
	public void launchRediff()
	{
		driver =  new EdgeDriver();
		driver.get("https://www.yahoo.com/?guccounter=1");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();


	}
	@Test(description="Login-Hard Assert",priority=2,enabled=false)
	public void loginRediff1()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Yahoo12");
		System.out.println("Assert Executed...");
	}
	@Test(description="Login-Soft Assert",priority=2)
	public void loginRediff()
	{
		SoftAssert assertion = new SoftAssert();
		
		String title=driver.getTitle();
		assertion.assertEquals(title, "Yahoo123");
		System.out.println("Assert Executed...");
		assertion.assertAll();
	}
	@Test(description="Close",priority=3)
	public void closeRediff()
	{
		driver.quit();
	}
}
