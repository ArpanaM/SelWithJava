package testNGLearning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Exp {

	Object[][] data;
	@DataProvider(name="data")
	public Object[][] dp()
	{
		data=new Object[3][2];
		data[0][0]="tani";
		data[0][1]="tani111";
		
		data[1][0]="riya";
		data[1][1]="riya111";
		
		data[2][0]="pooja";
		data[2][1]="pooja111";
		return data;
		
	}
	@Test(dataProvider = "data")
	public void dispData(String un,String pwd)
	{
		System.out.println(un+":"+pwd);
	}
}
