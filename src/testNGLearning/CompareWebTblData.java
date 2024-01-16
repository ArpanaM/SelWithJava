package testNGLearning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompareWebTblData {
	
ArrayList<String> exp_data = new ArrayList<String>();
ArrayList<String> act_data = new ArrayList<String>();
WebDriver driver;
FileReader fr;
BufferedReader br;
SoftAssert assertion;
String src="D:\\2023\\Sel@9AM(IST)\\data.txt";
	@Test(priority=1)
	public void readFrmTable()
	{
		driver =  new EdgeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		WebElement myTable=driver.findElement(By.id("customers"));
		List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("Total Number of Rows="+allRows.size());
		for(int i=1;i<allRows.size();i++)  //focus to Row  = 1
		{
			List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
			//System.out.println(allCols.size());
			for(int j=0;j<allCols.size();j++)
			{
				act_data.add(allCols.get(j).getText());
			}
			
		}
		System.out.println("Actual Array List Count="+act_data.size());
	}
	@Test(priority=2)
	public void readFrmTxtFile() throws IOException
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String content=null;
		while((content=br.readLine())!=null)
		{
			exp_data.add(content);
		}
		System.out.println("Expected Array List Count="+act_data.size());
		
	}
	@Test(priority=3)
	public void compareData()
	{
		
		for(int i=0;i<exp_data.size();i++)
		{
			System.out.println(exp_data.get(i)+" : "+act_data.get(i));
			//Assert.assertEquals(exp_data.get(i),act_data.get(i));
			assertion = new SoftAssert();
			assertion.assertEquals(act_data.get(i), exp_data.get(i));
			System.out.println("Assert Executed..");
			assertion.assertAll();

			
		}
	}
}
