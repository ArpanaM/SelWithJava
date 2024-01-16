package testNGLearning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ReadFrmWebTbl {

	WebDriver driver;
	String src="D:\\2023\\Sel@9AM(IST)\\data.txt";
	FileWriter fw;
	BufferedWriter bw;
	
	@Test
	public void readFrmWebTable() throws IOException
	{
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		
		driver =  new EdgeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
//		Dimension d=new Dimension(100,700);
//		driver.manage().window().setSize(d);
		WebElement myTable=driver.findElement(By.id("customers"));
		List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("Total Number of Rows="+allRows.size());
		for(int i=1;i<allRows.size();i++)  //focus to Row  = 1
		{
			List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
			//System.out.println(allCols.size());
			for(int j=0;j<allCols.size();j++)
			{
				System.out.println(allCols.get(j).getText());
				bw.write(allCols.get(j).getText());
				bw.newLine();
			}
			
		}
		bw.close();
		driver.quit();
		
		
	}
}
