package com.zoho.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public interface WebConnector extends ZohoWebConnector{
	
	void OpenBrowser(String BName);
	void navigate(String url);
	void quit();
	EventFiringWebDriver getCurrentDriver(); 
	void WaitForElementLoad(); //will be implemented later not now.
	ZohoTestSession getsession();
	boolean isStopExecution();
	void setStopExecution(boolean stopExecution);
	void assertAll();
	SoftAssert getSoftAssert();
    void setSoftAssert(SoftAssert softAssert);
    //void log(String msg);
    void fail(String message);
		
	

}
