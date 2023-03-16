package keywords;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;



public class GenericKeywords {
	public WebDriver driver;
	public Properties prop;
	public Properties envProp;
	public ExtentTest test;
	public SoftAssert softAssert;
	
	public void openBrowser(String browserName) {
		log("Opening the Browser i.e Chrome");
		if(browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome","path of the driver file.");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
	}
	
	public void navigate(String urlKey) {
		log("Navigating to the website "+urlKey);
		driver.get(envProp.getProperty(urlKey));
		
	}
	public void click(String locatorKey) {
		log("clicking on locator "+locatorKey);
		//getElement(prop.getProperty(locatorKey)).click();
		getElement(locatorKey).click();
		
	}
	
	public void type(String locatorKey,String data) {
		log("typing on to "+locatorKey+ " and inserting data "+data);
		//getElement(prop.getProperty(locatorKey)).sendKeys(data);
		getElement(locatorKey).sendKeys(data);
	}
	
    public void select(String locator,String value) {
    	
    }
    public void GetText(String locator) {
    	
    }
    
    public WebElement getElement(String locatorKey) {
    	//check element present
    	if(!isElementPresent(locatorKey)) {
    		//report failure
    		//System.out.println("element is not present "+locatorKey);
    	}
    	if(!isElementVisible(locatorKey)) {
    		//report failure
    		//System.out.println("element is not visible "+locatorKey);
    	}
    
    	WebElement e=driver.findElement(getLocator(locatorKey));
    
    	return e;
    	
    }
 public boolean isElementPresent(String locatorKey) {
 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
 try {
 wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));  		

 }
    	catch(Exception e) {
    		return false;
    	}
    	return false;
    	
    }
    public boolean isElementVisible(String locatorKey) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	try {
    wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));  	
    	
    	}catch(Exception e) {
    		return false;
    	}
    	return false;
    }
    
    public By getLocator(String locatorKey) {
    	By by=null;
    	if(locatorKey.endsWith("_id"))
    		by=By.id(envProp.getProperty(locatorKey));
    	else if(locatorKey.endsWith("_css"))
    		by=By.cssSelector(envProp.getProperty(locatorKey));
    	else if(locatorKey.endsWith("_name"))
    		by=By.name(envProp.getProperty(locatorKey));
    	else if(locatorKey.endsWith("_xpath"))
    		by=By.xpath(envProp.getProperty(locatorKey));
    	return by;
    }
    
    public void Wait(int time) {
    	try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void log(String message) {
    	System.out.println(message);
    	test.log(Status.INFO, message);
    }
    
    public void reportFailure(String message,boolean stopOnFailure) {
    	System.out.println("Executioj has been Failed.");
    	test.log(Status.FAIL, message);//failure in extent reports
    	takesScreenShot();//taking screen shots intoReports.
    	softAssert.fail(message);//failure in TestNG reports..
    	if(stopOnFailure) {
    		Reporter.getCurrentTestResult().getTestContext().setAttribute("criticalFail","yes");
    		assertAll();//report all the failures.
    	}
    }
    public void assertAll() {
    	//Reporter.getCurrentTestResult().getTestContext().setAttribute("criticalFail","yes");
    	softAssert.assertAll();
    }
    
    public void takesScreenShot() {
    //choosing the name of the screenshot file.
    Date d=new Date();
    String screenshotFile=d.toString().replace(":","_").replace(" ","_")+".png";
    //take the screenshot.
    File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
    	FileUtils.copyFile(srcFile,new File(ExtentManager.ScreenshotFolderPath+"//"+screenshotFile));
    //putting screenshot into Reports.
    	test.log(Status.INFO, "screenshot->"+test.addScreenCaptureFromPath(ExtentManager.ScreenshotFolderPath+"//"+screenshotFile));
    }
    catch(IOException e) {
    	e.printStackTrace();
    }
    	
    }
    
 public void logFailure(String failureMessage,boolean stopOnFailure) {
	 System.out.println(failureMessage);
	 test.log(Status.FAIL, failureMessage);
	 softAssert.fail(failureMessage);
	 
 }
 public void clear(String locatorKey) {
	 log("clearing the written text "+locatorKey);
	 getElement(locatorKey).clear();
 }
 
 public void selectByVisibleText(String locatorKey,String data) {
	 Select s=new Select(getElement(locatorKey));
	 s.selectByVisibleText(data);
 }
 
 public void acceptAlert() {
	 System.out.println("handling with the Alert");
	 test.log(Status.INFO, "handling Alert.Switching to the Alert pop up");
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.alertIsPresent());
	 try {
		 driver.switchTo().alert().accept();
		 //driver.switchTo().defaultContent();
		 test.log(Status.INFO,"Accepting the Alert ");
	 }catch(Exception e) {
		 reportFailure("not able to handle Alert Hence Failing the test case",true);
	 }
 }
 
 public String getText(String locatorKey) {
		return getElement(locatorKey).getText();
	}
 
 public void waitForPageToLoad() {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 int i=0;
	 while(i !=15) {
		 String state=(String)js.executeScript("return document.readyState;");
	     System.out.println("state of the page load is in status : "+state);
	     if(state.equals("complete"))
	    	 break;
		else
			try {
				wait(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	 i++;
	     
	 }
	 //checking the JQuery Status;
	 i=0;
	 while(i !=15) {
		 Long d=(Long) js.executeScript("return jQuery.active;");
		 System.out.println("JQuery status is "+d);
		 if(d.longValue()==0)
			 break;
		else
			try {
				wait(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 i++;
	 }
 }
 

	public void quit() {
		driver.quit();	
	}
 
 public void pressEnterButton(String locatorKey) {
	 test.log(Status.INFO,"pressing Enter Button");
	 getElement(locatorKey).sendKeys(Keys.ENTER);
 }
 
//finds the row number of the data
	public int getRowNumWithCellData(String tableLocator, String data) {
		
		WebElement table = getElement(tableLocator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int rNum=0;rNum<rows.size();rNum++) {
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(int cNum=0;cNum<cells.size();cNum++) {
				WebElement cell = cells.get(cNum);
				System.out.println("Text "+ cell.getText());
				if(!cell.getText().trim().equals(""))
					if(data.startsWith(cell.getText()))
						return(rNum+1);
			}
		}
		
		return -1; // data is not found
	}
 
    
}

