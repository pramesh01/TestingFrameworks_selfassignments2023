package com.zoho.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

import constants.Constant;

public class EnterPassword extends ZohoBasePage {
	
	
	@FindBy(xpath=Constant.submitButton)
	WebElement submitButton;
	@FindBy(xpath=Constant.LoginButton)
	WebElement Login;
	
	public ZohoPage gotopasswordsubmitpage(String password) {
		//log("navigating to the password submit page");
		//driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Ishu@284128");
		submitButton.sendKeys(password);
		//Login.click(); //disabled it to prevent the login.
		//driver.findElement(By.xpath("//*[@id='nextbtn']/span")).click();
		return null;
		
	}

}
