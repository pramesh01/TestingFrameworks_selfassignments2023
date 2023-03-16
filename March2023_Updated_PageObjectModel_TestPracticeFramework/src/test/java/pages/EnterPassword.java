package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basetest.BaseClass;
import constants.Constant;

public class EnterPassword extends BaseClass {
	@FindBy(xpath=Constant.submitButton)
	WebElement submitButton;
	//WebDriver driver;
	
	public EnterPassword (WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void gotoApplicationDashboard() {
		
		//driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Ishu@284128");
		submitButton.sendKeys("Ishu@284128");
		//driver.findElement(By.xpath("//*[@id='nextbtn']/span")).click();
	}

}
