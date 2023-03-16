package zoho.pages;

import zoho.manager.WebDriverManager;

public class LoginPage {
	
WebDriverManager app;
	
	public LoginPage(WebDriverManager app) {
		this.app=app;
	}
	
	public void doLogin() {
		//write code to login to website.//app.getProperty("username_xpath
		app.type("usernameTextField_xpath",app.getProperty("username"));
		app.click("nextButton_xpath");
		app.type("passwordTextField_xpath",app.getProperty("password"));
		//app.logFailure("some critical failure happened so failed as hard assertion", false);
		//app.click("submitButton_xpath");
		//if success - then ModuleSelectionPage
		//if not Success -then LoginPage
	}

}
