package testcases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class Session extends BaseTest{

	@Test
	public void doLogin(ITestContext context) {
		//test.log(Status.INFO,"Login to the application");
		app.log("Login to the application");
		app.openBrowser("chrome");
		app.navigate("URL");
		app.click("signinLink_xpath");
		app.type("UserName_xpath", "Parthik.Verma");
		app.type("UserPassword_xpath","Renu@12345");
		//app.reportFailure("Report the failure message.Test is Incorrect",false);
		app.validateElementPresent("LoginButton_xpath");
		app.click("LoginButton_xpath");
		app.Wait(3);
		app.validateLoginSuccessful("signOutButton_xpath");
		app.assertAll();
		
		
	}
	
	@Test
	public void doLogout() {
		test.log(Status.INFO,"logout from the application");
	}
}
