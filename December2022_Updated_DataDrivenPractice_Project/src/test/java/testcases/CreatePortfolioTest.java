package testcases;

import org.testng.annotations.Test;

import keywords.ApplicationKeywords;

public class CreatePortfolioTest {
	ApplicationKeywords app=new ApplicationKeywords();
	
	
	@Test
	public void createPortFolioTest() {
		app.openBrowser("chrome");
		app.navigate("URL");
		app.click("signinLink_xpath");
		app.type("UserName_xpath", "Parthik.Verma");
		app.type("UserPassword_xpath","Renu@12345");
		app.validateElementPresent("LoginButton_xpath");
		app.click("LoginButton_xpath");
		app.Wait(4);
		app.validateLoginSuccessful("signOutButton_xpath");
		
		
	}

}
