package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basetest.BaseClass;
import constants.Constant;

public class ApplicationHomePage extends BaseClass {
	
	@FindBy(xpath=Constant.loginLink)
	WebElement loginLink;
	//WebDriver driver;
	
	public ApplicationHomePage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public EnterUserName gotoLoginPage() {
		//driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/a[4]")).click();
		loginLink.click();
		return new EnterUserName(driver);
		//return PageFactory.initElements(driver,EnterUserName.class);
		
	}

}
