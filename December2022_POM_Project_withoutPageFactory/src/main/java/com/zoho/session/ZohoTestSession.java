package com.zoho.session;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.reports.ExtentManager;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoDriver;

import constants.Constant;

public class ZohoTestSession {
	WebConnector con;
	ZohoPage currentPage;
	ExtentReports reports;
	ExtentTest test;
	boolean executeListener;
	
	 public ZohoTestSession() {
			con=new ZohoDriver(); // -> ZohoDriver is for Web Layer.
		}
	
	public ZohoPage getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(ZohoPage currentPage) {
		this.currentPage = currentPage;
	}
   
	public void init(String testName) {
		//setExecuteListener(true);
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session")==null) 
		Reporter.getCurrentTestResult().getTestContext().setAttribute("session",this);
	
		//initializing the reports
		reports=ExtentManager.getReports(Constant.Reports_Path);
		test=reports.createTest(testName);
		
		//ZohoPage page=new LaunchPage();
		//return new LaunchPage();
	}
	
       public WebConnector getCon() {
		 return con;
	   }
  
public void end() {
getCon().assertAll();
	
}

public void generateReports() {
	if(reports != null)
	reports.flush();
	//close the browser
	//if(getCon() !=null)   -- commenting it for the time being later will enable it.
		//getCon().quit();
}

public void failTest(String failuremsg) {
//test.log(Status.FAIL,failuremsg);
takesScreenShot();
test.log(Status.FAIL,failuremsg);	
}

public void takesScreenShot() {
    //choosing the name of the screenshot file.
    Date d=new Date();
    String screenshotFile=d.toString().replace(":","_").replace(" ","_")+".png";
    //take the screenshot.
    File srcFile=((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
    try {
    	FileUtils.copyFile(srcFile,new File(ExtentManager.ScreenshotFolderPath+"//"+screenshotFile));
    //putting screenshot into Reports.
    	test.log(Status.INFO, "screenshot->"+test.addScreenCaptureFromPath(ExtentManager.ScreenshotFolderPath+"//"+screenshotFile));
    }
    catch(IOException e) {
    	e.printStackTrace();
    }
    	
    }
public boolean isExecuteListener() {
	return executeListener;
}

public void setExecuteListener(boolean executeListener) {
	this.executeListener = executeListener;
}

public void skipTest(String message) {
	test.log(Status.SKIP, message);
}
public void log(String message) {
	test.log(Status.INFO, message);
}

}