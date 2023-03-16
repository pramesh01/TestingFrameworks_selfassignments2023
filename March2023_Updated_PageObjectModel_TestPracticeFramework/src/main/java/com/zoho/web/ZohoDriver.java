package com.zoho.web;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.zoho.listener.ZohoEventListener;


public class ZohoDriver extends ZohoValidationDriver  {
	//EventFiringWebDriver driver;
	//this class is responsible for all Webdriver commands 
	
	public void logOut() {
			
	}

	public void navigate(String url) {
		log("Navigating to url "+url);
		driver.get(url);
		
	}

	public void quit() {
	
		
	}

	public void OpenBrowser(String BName) {
		//WebDriver driver=new ChromeDriver();
		log("opening the browser "+BName);
		driver=new EventFiringWebDriver(new ChromeDriver());
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
		// TODO Auto-generated method stub
		
	}
}