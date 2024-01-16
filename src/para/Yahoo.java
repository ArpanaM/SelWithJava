package para;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Yahoo {

		@Test
		@Parameters({"un","pwd"})
		public void loginYahoo(String uname,String passwd)
		{
			System.out.println("Login to yahoo using the below credentials--");
			System.out.println(uname+" : "+passwd);
		}
}
