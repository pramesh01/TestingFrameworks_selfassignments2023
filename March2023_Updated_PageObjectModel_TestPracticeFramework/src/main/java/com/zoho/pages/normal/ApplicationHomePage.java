package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

import constants.Constant;


public class ApplicationHomePage extends ZohoBasePage {
	
	@FindBy(xpath=Constant.loginLink)
	WebElement loginLink;
	
	public ZohoPage gotouserenteringpage() {
		log("going to the application's home page");
		loginLink.click();
		return new EnterUserName();
		
		
	}
	

}
