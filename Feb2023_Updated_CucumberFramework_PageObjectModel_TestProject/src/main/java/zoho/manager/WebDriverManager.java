package zoho.manager;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class WebDriverManager {
	
	WebDriver driver;
	ExtentTest test;
	 Properties prop;
	 SoftAssert softAssert;
	 
	
	 public WebDriverManager() {
		//initialize the .properties file.
		 try {
			 prop= new Properties();
			 String path=System.getProperty("user.dir")+"//src//test//resources//project.properties";
			 FileInputStream fs=new FileInputStream(path);
			 prop.load(fs);
		   }   catch(Exception e) {
			 e.printStackTrace();
		 }
		 softAssert=new SoftAssert();
	    }
	
	public void init(ExtentTest test) {
		this.test=test;
	  }
	
	 public void log(String msg) {
		  test.log(Status.INFO,msg);
	    }
	
	public void openBrowser(String browser) {
		log("launching the browser "+browser);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	public void navigate(String urlKey) {
		log("navigating to the website "+getProperty(urlKey));
		driver.get(getProperty(urlKey));
	}
	
	  public void click(String locatorKey) {
	     log("clicking on the element "+locatorKey);
		//driver.findElement(getLocator(locatorKey)).click();	
		findElement(locatorKey).click();
	}
	
	public void type(String locatorKey,String data) {
		 log("typing on the element "+locatorKey+ " and data is "+data);
		 //driver.findElement(getLocator(locatorKey)).sendKeys(data);
		 findElement(locatorKey).sendKeys(data);
      }
	
	public String getProperty(String key) {
	  	return prop.getProperty(key);
	   }
	
	public WebElement findElement(String locatorKey) {
		By locator=getLocator(locatorKey);
		WebElement e=null;
		try {
			    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		e=driver.findElement(locator);
		}catch(Exception exception) {
			//report the failure message.
			logFailure("object is not found . hence Failing the test case."+locatorKey,true);
		}
		return e;
		}
	 
	public By getLocator(String locatorKey) {
		
		if(locatorKey.endsWith("_xpath"))
			 return By.xpath(getProperty(locatorKey));
		else if(locatorKey.endsWith("_css"))
			 return By.cssSelector(getProperty(locatorKey));
		 else if(locatorKey.endsWith("_id"))
			 return By.id(getProperty(locatorKey));
		 else
			 return By.name(getProperty(locatorKey));	
	}
	
	 public void logFailure(String message,boolean stopExecution) {
		test.log(Status.FAIL, message);//fail in extentReports.
		  //Assert.fail(message);- hard assertion. & it will fail the test case
		  softAssert.fail(message); //soft assert so will continue with the executions.
		  if(stopExecution)
		  softAssert.assertAll();
	      }

	   public void finished() {
		 if(softAssert != null)
			 softAssert.assertAll();
		
	       }
            }
