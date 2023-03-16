package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeywords extends ValidationKeywords {
	//ExtentTest test;
	
	public ApplicationKeywords() {
		String path=System.getProperty("user.dir")+"//src//test//resources//ProjectEnvironment.properties";
		prop=new Properties();
		envProp=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream(path);
			prop.load(fis);
			String ProjectEnvironment=prop.getProperty("environment")+".properties";
			path=System.getProperty("user.dir")+"//src//test//resources//"+ProjectEnvironment;
			fis=new FileInputStream(path);	
			envProp.load(fis);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		softAssert=new SoftAssert();
	}
	public void login() {
		
	}
	public void selectDate() {
		
	}
	public void verifyStockAdded() {
			
	}
	
	public void setReport(ExtentTest test) {
		this.test=test;
		
	}
	public void selectDateFromCalendar(String date) {
		log("Selecting Date "+date);
		
		try {
			Date currentDate = new Date();
			Date dateToSel=new SimpleDateFormat("d-MM-yyyy").parse(date);
			String day=new SimpleDateFormat("d").format(dateToSel);
			String month=new SimpleDateFormat("MMMM").format(dateToSel);
			String year=new SimpleDateFormat("yyyy").format(dateToSel);
			String monthYearToBeSelected=month+" "+year;
			String monthYearDisplayed=getElement("MonthYear_css").getText();
			
			while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
				click("datebackButoon_xpath");
				monthYearDisplayed=getElement("MonthYear_css").getText();
			}
			driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToBuySell(String companyName) {
		log("Selecting the company row "+companyName );
		int row = getRowNumWithCellData("applicationTable_css", companyName);
		if(row==-1) {
		log("Stock not present in list");
		}
		driver.findElement(By.cssSelector(envProp.getProperty("applicationTable_css")+" > tr:nth-child("+row+") >td:nth-child(1)")).click();
		driver.findElement(By.cssSelector(envProp.getProperty("applicationTable_css")+"  tr:nth-child("+row+") input.buySell" )).click();	
	    }
	
	
	public void defaultLogin() {
		navigate("URL");
		click("signinLink_xpath");
		type("UserName_xpath",envProp.getProperty("username"));
		type("UserPassword_xpath",envProp.getProperty("password"));
		click("LoginButton_xpath");
		//waitForPageToLoad();
		Wait(5);
		//validateLoginSuccessful("signOutButton_xpath");
	}
 }
