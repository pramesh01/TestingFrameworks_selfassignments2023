package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

import constants.Constant;


public class EnterUserName extends ZohoBasePage{
	
	
	
	//@FindBy(xpath=Constant.username)
	//WebElement username;
	
	//@FindBy(xpath=Constant.nextButton)
	//WebElement nextButton;
	
	public ZohoPage gotousernamesubmitpage(String userid) {
		log("going into user entering page");
	//username.sendKeys(userid);
		getDriver().type("username_xpath", "userName");
	//driver.findElement(By.xpath("//*[@id='nextbtn']")).click();
	//nextButton.click();
		getDriver().click("nextButton_xpath");
	//validate if password entering text box is present or not.
	boolean isPasswordPresent=validator(false).isElementPresent(Constant.PasswordTextArea_locator);
	System.out.println("Password text area field is available continue the test case..");
	if(isPasswordPresent) {
	return new EnterPassword();
	}
	else {
		System.out.println("wrong username is entered");
		return this;
	}

}
}