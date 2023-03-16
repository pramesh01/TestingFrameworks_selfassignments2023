package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basetest.BaseClass;
import constants.Constant;

public class EnterUserName extends BaseClass {
	
	@FindBy(xpath=Constant.username)
	WebElement username;
	
	@FindBy(xpath=Constant.nextButton)
	WebElement nextButton;
	
	//WebDriver driver;
	public EnterUserName(WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public EnterPassword gotouserenteringpage() {
		//driver.findElement(By.xpath("//*[@id='login_id']")).sendKeys("bloggerdelhi123@gmail.com");
		username.sendKeys("bloggerdelhi123@gmail.com");
		//driver.findElement(By.xpath("//*[@id='nextbtn']")).click();
		nextButton.click();
		return new EnterPassword(driver);
		//return PageFactory.initElements(driver,EnterPassword.class);
	}

}
