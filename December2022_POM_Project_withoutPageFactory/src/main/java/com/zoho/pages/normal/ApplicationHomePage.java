package com.zoho.pages.normal;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import constants.Constant;

public class ApplicationHomePage extends ZohoBasePage {
	
	//@FindBy(xpath=Constant.loginLink)
	//WebElement loginLink;
	
	public ZohoPage gotouserenteringpage() {
		log("going to the application's home page");
		getDriver().click("loginLink_xpath");
		return new EnterUserName();
	 }
	    }
