package testNGLearning;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThruExcel {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	FileInputStream fis;
	String src="D:\\2023\\Sel@9AM(IST)\\data.xlsx";
	Object[][] data;
	@DataProvider(name="data")
	public Object[][] readFrmExcel() throws IOException
	{
		fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		sheet1=wb.getSheetAt(0);
		int rowCount=sheet1.getLastRowNum();
		int colCount=sheet1.getRow(0).getLastCellNum();
		System.out.println("Rows="+rowCount+" "+"Columns="+colCount);
		data=new Object[rowCount][colCount];
		System.out.println("Fetch data from excel");
		for(int i=0;i<rowCount;i++)  //i=0
		{
			for(int j=0;j<colCount;j++)  //j=0
			{
				data[i][j]=sheet1.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}
	
	public void launchYahoo()
	{
		System.out.println("Launch Yahoo..");
	}
	@Test(dataProvider = "data")
	public void loginYahoo(String un,String pwd)
	{
		System.out.println("Login Yahoo..");
		System.out.println(un+" : "+pwd);
	}
	public void logoutYahoo()
	{
		System.out.println("Exit Yahoo...");
	}
}
