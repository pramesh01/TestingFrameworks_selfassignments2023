package com.zoho.base.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoBasePage implements ZohoPage{
	
	public ZohoBasePage() {
		//System.out.println("-----------inside ZohoBasePage constructor-----------");
		PageFactory.initElements(getCurrentDriver(), this);
		//set the current page in session.
		getsession().setCurrentPage(this);
	}

	public void gotoHomePage() {
		
		
	}

	public void gotoRegisterPage() {
		// TODO Auto-generated method stub
		
	}

	public void submitUserName() {
		// TODO Auto-generated method stub
		
	}

	public WebConnector Validator(boolean stopExecution) {
		return getsession().getCon();
		
	}
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub
		
	}

	public void CreateDeal() {
		// TODO Auto-generated method stub
		
	}

	public void LogOut() {
		// TODO Auto-generated method stub
		
	}

	public ZohoPage gotoApplicationHomePage() {
		return null;
		
	}

	public void gotoLoginPage() {
		// TODO Auto-generated method stub
		
	}

	public ZohoPage  gotouserenteringpage() {
		return null;
		// TODO Auto-generated method stub
		
	}
	public ZohoPage gotopasswordenteringpage() {
		return null;
	}

	public void gotoApplicationDashboard() {
		// TODO Auto-generated method stub	
	}
	
	public ZohoTestSession getsession() {
    return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");		
	}

	public ZohoPage OpenBrowser(String bName) {
	   	return null;
	 }
	
	public WebConnector getDriver() {
		return getsession().getCon();
		
	}
	public EventFiringWebDriver getCurrentDriver() {
		return getsession().getCon().getCurrentDriver();
	}

	public WebConnector validator(boolean stopExecution) {
		//update the flag into web layer.
		getsession().getCon().setStopExecution(stopExecution);
		return getsession().getCon();
		
	}

	public ZohoPage gotousernamesubmitpage(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZohoPage gotopasswordsubmitpage(String userid) {
		
		return null;
	}
	
	public void log(String msg) {
		getsession().log(msg);
	}
	

	public boolean isExecuteListener() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setExecuteListener(boolean executeListener) {
		// TODO Auto-generated method stub
		
	}

	
      }
