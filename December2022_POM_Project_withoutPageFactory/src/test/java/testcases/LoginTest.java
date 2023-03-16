package testcases;

import java.util.Hashtable;
import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zoho.base.pages.ZohoPage;
import com.zoho.dataprovider.TestDataProvider;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.session.ZohoTestSession;
import constants.Constant;
import pages.EnterPassword;
import pages.EnterUserName;
import testbase.TestBase;

public class LoginTest extends TestBase {

	/* ZohoTestSession session;
	String testName="LoginTest";
	Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	@BeforeMethod
	public void init() {
		session=new ZohoTestSession();
		//apply the external source data 
		//zohoLaunchPage=session.init("Login Test");
		session.init(testName);
	}
	@AfterMethod
	public void quit() {
		session.generateReports();	
	}*/
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getData")
	public void loginTest(Hashtable<String,String> data) {
		session.log(data.toString());
		if(!DataUtil.isRunnable(testName, xls) || data.get("RunMode").equals("N")) {
			System.out.println("Do not test any test case");
			//Skip  in extent Reports
			session.skipTest("skipping in extent reports as RunMode is set as - NO");
			
	//Skip in test NG
	throw new SkipException("skipping this test case in TestNG as RunMode is mentioned as - NO");
		}
		else {
		
		//String userName="bloggerdelhi123@gmail.com";
		String userName=data.get("UserName");
		String password=data.get("Password");
		String userNameValid=data.get("UserNameValid");
		String actualText="Your Life's Work, Powered By Our Life's Work";
		//ZohoTestSession session=new ZohoTestSession(); //  WebConnector is initialized.
		
		 new LaunchPage()
   	     .OpenBrowser("chrome")
		 .gotoApplicationHomePage()
		 .validator(false).validateTitle(Constant.HomePageTitle_key)
		 .validator(false).validateText(Constant.HomePageText_key, actualText)
		 .validator(true).validateElementPresent(Constant.loginLinklocator_xpath)
		 .gotouserenteringpage()
		 .gotousernamesubmitpage(userName)
		 .gotopasswordsubmitpage(password);
		
		
		/* ZohoPage page=
    		 //session//remove these two lines and add zohoLaunchPage
		   // store session in testContext, return Object of LaunchPage;
		// zohoLaunchPage
    	 new LaunchPage()
    	 .OpenBrowser("chrome")
		 .gotoApplicationHomePage()
		 .validator(false).validateTitle(Constant.HomePageTitle)
		 .validator(false).validateText(Constant.HomePageText_Locator, actualText)
		 .validator(true).validateElementPresent(Constant.loginLink_locator)
		 .gotouserenteringpage()
		 .gotousernamesubmitpage(userName);

		 if(page instanceof EnterUserName & userNameValid.equals("Y")) {
			 //failure
			 page.validator(true).fail("cound not enter because of not moving next page ");
		 }
		 else if(page instanceof EnterPassword) {
			 if(userNameValid.equals("N")) {
				 //failure
				 page.validator(true).fail("could not move because of invalid user name");
			 }}
		 else {  //proceed further
			 page.gotopasswordsubmitpage(password);
			 }      */
		  session.end(); 
	    }
	}
}