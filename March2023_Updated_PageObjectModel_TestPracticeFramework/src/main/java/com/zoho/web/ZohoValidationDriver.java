package com.zoho.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

import io.netty.handler.timeout.TimeoutException;

public abstract class ZohoValidationDriver implements WebConnector {

	EventFiringWebDriver driver;
	boolean stopExecution;
	SoftAssert softAssert=new SoftAssert();
	
	//This class is having all the validation relation functions.
	
	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}

	public ZohoPage validateTitle(String expectedTitle) {
		log("actual title is "+driver.getTitle());
		log("expected title is "+expectedTitle);
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		//System.out.println("Satus is  "+isStopExecution());
		if(!expectedTitle.equals(driver.getTitle())) {
			fail("execution is failed.title do not matched "+driver.getTitle());
			//softAssert.fail("Execution has been failed since title do not matched"+driver.getTitle());
			      //if(isStopExecution())
			    	 // assertAll();	
		      }
		return getsession().getCurrentPage();
	   }
	public ZohoPage validateText(By locator,String expectedText) {
		String actualText=driver.findElement(locator).getText();
		if(!expectedText.equals(actualText)) {
			fail("execution failed since Header text DOES not matches"+actualText);
		}
		System.out.println("Validate Text status is "+isStopExecution());
		return getsession().getCurrentPage();
		
	}
	
	public ZohoPage validateElementPresent(By locator) {
		 if(!isElementPresent(locator)) {
	      //log("element is not present in page."+locator);
			 fail("Element is not present thats why failing this test case "+locator);
		 }
		// log("WebElement is present and available.."+locator);
		 return getsession().getCurrentPage();
	 }
	
	public boolean isElementPresent(By locator) {
		getsession().setExecuteListener(false);
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		 try {
		 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		 }
		 catch(TimeoutException e) {
			getsession().setExecuteListener(true);
			 return false;
		 }
		 getsession().setExecuteListener(true);
		 return true;
	 }
	
	public ZohoTestSession getsession() {
	    return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");		
	  }

	public void validateLogin() {
		
	}
	
	public void assertAll() {
		//you can add the failed tests screen shots here..
		softAssert.assertAll();
	}
	
	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	//public ZohoPage validateElementPresent(String locatortype, String locator) {
		//return getsession().getCurrentPage();
	//}
	
	public void fail(String message) {
	 //fail in testNG
		getsession().failTest(message); //fail in extentReports.
		//fail in ExtentReports
		softAssert.fail(message);
		if(isStopExecution())
			assertAll();
	   }
	 public void log(String msg) {
		getsession().log(msg);
	     }
          }