package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basetest.BaseClass;

public class OpenBrowser extends BaseClass {
	
	//WebDriver driver;
	public OpenBrowser(WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
		}
	
	public ApplicationHomePage gotoApplicationHomePage() {
		driver.get("https://www.zoho.com");
		return new ApplicationHomePage(driver);
		//return PageFactory.initElements(driver,ApplicationHomePage.class);
	}

}
