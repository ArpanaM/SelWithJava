package para;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Gmail {

		@Test
		@Parameters({"un","pwd"})
		public void loginGmail(String uname,String passwd)
		{
			System.out.println("Login to gmail using the below credentials--");
			System.out.println(uname+" : "+passwd);
		}
}
