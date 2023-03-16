package testbase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;
import runner.DataUtil;
import util.XlsFile_Reader;

public class BaseTest {
	
	public ApplicationKeywords app;
	public ExtentReports rep;
	public ExtentTest test;
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest(ITestContext context) throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		System.out.println("Before the starting of Every test");
		String datafilpath =context.getCurrentXmlTest().getParameter("datafilpath");
		String dataFlag =context.getCurrentXmlTest().getParameter("dataFlag");
		String iteration =context.getCurrentXmlTest().getParameter("iteration");
		//-> for xls data Read only
		String sheetName =context.getCurrentXmlTest().getParameter("suitename");
		System.out.println(datafilpath);
		System.out.println(dataFlag);
		System.out.println(iteration);
		System.out.println(sheetName);
		
		//JSONObject data=new DataUtil().getTestData(datafilpath,dataFlag,Integer.parseInt(iteration));
		JSONObject data=new XlsFile_Reader().getTestData(sheetName, dataFlag, (Integer.parseInt(iteration)+1), datafilpath);
		context.setAttribute("data", data);//-->setting data for the test cases
		String runmode=(String)data.get("runmode");
		
		//initialize and share with all the tests
		//app=new ApplicationKeywords();
		//context.setAttribute("app", app);
		
		//initialize the ExtentReports and ExtentTest
		rep=ExtentManager.getReports();
		test=rep.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "starting the test case name "+context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Data is "+data.toString());//-->to report data in test logs
		context.setAttribute("report", rep);
        context.setAttribute("test", test);
       
        if(!runmode.equals("Y")) {
			test.log(Status.SKIP,"skipping the test case as runmode is N ");
			throw new SkipException("skipping as data runmode is N");
		}
        
        app=new ApplicationKeywords();
        app.setReport(test);
        app.openBrowser("chrome");
        app.defaultLogin();
        context.setAttribute("test",test);
        context.setAttribute("app", app);
        
	}
	@AfterTest(alwaysRun=true)
	public void quit(ITestContext context) {
		System.out.println("after the Test.");
		app = (ApplicationKeywords)context.getAttribute("app");
		if(app!=null)
			app.quit();
		
		rep = (ExtentReports)context.getAttribute("report");
		if(rep !=null)
			rep.flush();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(ITestContext context) {
		System.out.println("before every method");
		test=(ExtentTest) context.getAttribute("test");//promoted later
		//for report failure purposes
		String failure=(String) context.getAttribute("criticalFail");
		if(failure !=null && failure.equals("yes")) {
		test.log(Status.SKIP,"Failing in extent report because of some very critical issues.");//failed in ExtentReports.
		throw new SkipException("Critical failure occurs in the test case ");//skip in TestNG
		}
			
		app=(ApplicationKeywords) context.getAttribute("app");
		//getting the ExtentReport and ExtentTest context.
		app.setReport(test);//for logs at every steps;
		rep=(ExtentReports) context.getAttribute("report");
		//test=(ExtentTest) context.getAttribute("test");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		System.out.println("after every method");
	}

}
