package webDriverLearning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkingWithDifferentBrows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> exp_data=new ArrayList<String>();
		exp_data.add("Days");
		exp_data.add("Months");
		exp_data.add("Years1");
		WebDriver driver =  new ChromeDriver();
		//WebDriver driver =  new EdgeDriver();
		driver.get("https://vindeep.com/Calculators/FDCalc.aspx");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("Title="+title);
		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).clear();
		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).sendKeys("10000");
		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).clear();
		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).sendKeys("70");
		//code for FD Period Dropdownbox
		Select opts = new Select(driver.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown")));
		opts.selectByVisibleText("Days");
		//count no. of items in a dropdownbox
		List<WebElement> allItems = opts.getOptions();
		System.out.println("total options="+allItems.size());
		//print all the options
		for(int i=0;i<allItems.size();i++)
		{
			System.out.println(allItems.get(i).getText());
			if(exp_data.get(i).equals(allItems.get(i).getText()))
			{
				System.out.println("Item matched...");
			}
			else
			{
				System.err.println("Item not matched...");
			}
		}
		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).clear();
		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).sendKeys("5.40");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$btnFDMAmount")).click();
		Thread.sleep(5000);
		String fd_amount=driver.findElement(By.id("ContentPlaceHolder1_cphCentre_MaturityAmountTextBox")).getAttribute("value");
		System.out.println("FD Amount="+fd_amount);
		driver.quit();// closes the browser and destroys the driver object
		
		
	}

}
