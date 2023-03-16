package com.zoho.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

import constants.Constant;

public class EnterPassword extends ZohoBasePage {
	
	
	//@FindBy(xpath=Constant.PasswordTextArea)
	//WebElement PasswordTextArea;
	//@FindBy(xpath=Constant.LoginButton)
	//WebElement Login;
	
	public ZohoPage gotopasswordsubmitpage(String password) {
		//log("navigating to the password submit page");
		//driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Ishu@284128");
		//submitButton.sendKeys(password);
		getDriver().type("password_xpath", "password");
		//Login.click(); //disabled it to prevent the login.
		//getDriver().click("submitButton_xpath");
		//driver.findElement(By.xpath("//*[@id='nextbtn']/span")).click();
		return null;
		
	}

}
