package testcases.rediff;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class PortfolioManagement extends BaseTest {

	@Test
	public void createPortfolio(ITestContext context) {
		JSONObject data=(JSONObject)context.getAttribute("data");
		String portfolioName=(String)data.get("portfolioname");
		app.log("creating new portfolio");
		app.click("createLink_id");
		app.clear("createTextBox_id");
		app.type("createTextBox_id",portfolioName );
		app.click("createPortfolioLink_xpath");
		app.Wait(5);
		//app.waitForPageToLoad();
		//app.validateSelectedValueInDropDown("portFolioDropDown_id",portfolioName );	
		
	}
	
	@Test
	public void deletePortfolio(ITestContext context) {
		
       JSONObject data=(JSONObject)context.getAttribute("data");
		String portfolioName=(String)data.get("portfolioname");
		
		test.log(Status.INFO,"deleting the portfolio");
		app.log("deleting the portfolio from drop down list.");
		app.selectByVisibleText("portFolioDropDown_id", portfolioName);
		//app.waitForPageToLoad();
		app.Wait(5);
		app.click("deleteLink_id");
		app.acceptAlert();
		app.Wait(3);
		//app.waitForPageToLoad();
		//app.validateSelectedValueNotInDropDown("portFolioDropDown_id", portfolioName);

	}
	
	@Test
	public void verifyPortfolio() {
        test.log(Status.INFO,"verifying the portfolio");		
		
	}
	@Test
	public void selectPortFolio() {
		app.log("Selecting the portfolio from the drop down list");
		app.selectByVisibleText("portFolioDropDown_xpath", "Pramesh_005");
		app.Wait(5);
	}
}
