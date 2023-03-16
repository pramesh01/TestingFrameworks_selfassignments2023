package zoho.context;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import zoho.manager.PageObjectManager;
import zoho.reports.ExtentManager;

public class TestContext {
	
	ExtentReports report;
	ExtentTest test;
	private PageObjectManager pageObjectManager;
	
	public TestContext() {
		System.out.println("test context constructor");
		report=ExtentManager.getReports(); // it initialize the Reports.
		this.pageObjectManager=new PageObjectManager();
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public void createScenario(String scenarioName) {
		test=report.createTest(scenarioName);
		this.pageObjectManager.getWebDriverManager().init(test);
		}
	
	 public void endScenario() {
		report.flush();
	  }
	 
	 public void log(String msg) {
		// test.log(Status.INFO, msg);
		 this.pageObjectManager.getWebDriverManager().log(msg);
	 }
       }
