package com.zoho.web;

import org.openqa.selenium.By;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector {

	//ZohoWebConnector
	void logOut();
	ZohoPage validateTitle(String expectedTitle);
	void validateLogin();
	ZohoPage validateText(String objectKey,String expectedText);
	ZohoPage validateElementPresent(String objectKey);
	boolean isElementPresent(String objectKey);
	boolean isExecuteListener();
	void setExecuteListener(boolean executeListener);
	void log(String msg);
	
	
	
}
