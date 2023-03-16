package testbase;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.zoho.session.ZohoTestSession;
import com.zoho.util.Xls_Reader;

public class TestBase {
	
	public ZohoTestSession session;
	//public String testName="LoginTest";
	public String testName=null;
public 	Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	@BeforeMethod
	public void init(ITestResult result) {
		testName=result.getMethod().getMethodName().toUpperCase();
		System.out.println("test base testname is "+testName);
		session=new ZohoTestSession();
		//apply the external source data 
		//zohoLaunchPage=session.init("Login Test");
		session.init(testName);
	}
	
	@AfterMethod
	public void quit() {
		session.generateReports();	
	}

}
