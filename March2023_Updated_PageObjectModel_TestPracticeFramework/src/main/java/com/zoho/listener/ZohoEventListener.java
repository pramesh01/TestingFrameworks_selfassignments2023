package com.zoho.listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

import io.netty.handler.timeout.TimeoutException;

public class ZohoEventListener extends AbstractWebDriverEventListener {
	
	public void beforeFindBy(By locator,WebElement element,WebDriver driver) {
		
		//if(getsession().isExecuteListener()) {
	         	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		        try  {
		       wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		       wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		          }
		       catch(TimeoutException e) {
			     getDriver().fail("element is not found "+locator);
			     getDriver().assertAll(); 
		   // }
	     }
	  }
	
	public ZohoTestSession getsession() {
	    return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");		
	  }
	
	public WebConnector getDriver() {
		return getsession().getCon();
		
	}
	public void log(String msg) {
		getsession().log(msg);
	}

}
