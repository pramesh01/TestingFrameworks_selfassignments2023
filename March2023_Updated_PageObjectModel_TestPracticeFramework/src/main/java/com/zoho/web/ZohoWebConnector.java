package com.zoho.web;

import org.openqa.selenium.By;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector {

	//ZohoWebConnector
	void logOut();
	ZohoPage validateTitle(String expectedTitle);
	void validateLogin();
	ZohoPage validateText(By locator,String expectedText);
	ZohoPage validateElementPresent(By locator);
	boolean isElementPresent(By locator);
	boolean isExecuteListener();
	void setExecuteListener(boolean executeListener);
	void log(String msg);
	
	
	
}
