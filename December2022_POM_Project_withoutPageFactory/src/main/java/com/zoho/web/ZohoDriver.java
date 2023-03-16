package com.zoho.web;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.zoho.listener.ZohoEventListener;


public class ZohoDriver extends ZohoValidationDriver  {
	//EventFiringWebDriver driver;
	//this class is responsible for all Webdriver commands 
	
	//constructor of ZohoDriver.
	public ZohoDriver() {
		//initialize the .property file here first..
		//System.out.println("ZohoDriver constructor");
		try {
		prop=new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties");
		prop.load(fs);
		//System.out.println(prop.get("url"));
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		}
	
	public void logOut() {
			
	}

	public void navigate(String urlKey) {
		log("Navigatig to web "+urlKey);
		String url=prop.getProperty(urlKey);
		log("Navigating to url "+url);
		driver.get(url);
	}

	public void quit() {
	if(driver != null)
		driver.quit();
	}

	public void OpenBrowser(String BName) {
		//WebDriver driver=new ChromeDriver();
		log("opening the browser "+BName);
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver=new EventFiringWebDriver(new ChromeDriver(opt));
		driver.register(new ZohoEventListener());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public EventFiringWebDriver getCurrentDriver() {
		return driver;
	}

	public void WaitForElementLoad() {
		
		
	}
	public void log(String msg) {
		getsession().log(msg);
}

	public boolean isExecuteListener() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setExecuteListener(boolean executeListener) {
			
	}
	
	public void click(String objectKey) {
		log("clicking on element "+objectKey);
		//driver.findElement(By.xpath(prop.getProperty(objectKey))).click();
		driver.findElement(getObject(objectKey)).click();
	}
	public void type(String locatorKey,String data) {
		log("typing on  "+locatorKey+  "  and Data . "+data);
		//driver.findElement(By.xpath(prop.getProperty(locatorKey))).sendKeys(prop.getProperty(data));
		driver.findElement(getObject(locatorKey)).sendKeys(prop.getProperty(data));
	}
}