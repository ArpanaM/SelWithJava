package webDriverLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiListBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement ele=driver.findElement(By.id("cars"));// webelement is ised to store web objects.
		Select allOpts = new Select(ele);
		allOpts.selectByIndex(0);
		allOpts.selectByValue("saab");
		allOpts.selectByVisibleText("Audi");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		String selCars=driver.findElement(By.xpath("/html/body/div[1]")).getText();
		System.out.println("Selected Cars="+selCars);
		
	}

}
