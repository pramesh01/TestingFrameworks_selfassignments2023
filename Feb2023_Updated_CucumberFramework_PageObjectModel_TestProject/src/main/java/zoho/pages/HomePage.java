package zoho.pages;

import com.aventstack.extentreports.ExtentTest;

import zoho.manager.WebDriverManager;

public class HomePage {
	
	WebDriverManager app;
	
	
	public HomePage(WebDriverManager app) {
		this.app=app;
	}

	public void gotologinpage() {
		//write webdriver code here to click on singnin link..
		app.log("trying to click on the signin link to proceed further. ");
		app.click("signin_link_css");
		//return new LoginPage();
	}
	
	 public void load(String browser) {
		 app.log("trying to load the website after opening the browser.");
		 app.openBrowser(browser);
		 app.navigate("url");
		
	  }
}
