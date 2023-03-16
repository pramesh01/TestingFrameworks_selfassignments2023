package zoho.manager;

import zoho.pages.HomePage;
import zoho.pages.LoginPage;

    public class PageObjectManager {
	
	   HomePage homePage;
	   LoginPage loginPage;
	   WebDriverManager app;
	   
	   public PageObjectManager() {
		   this.app=new WebDriverManager();
	    }
	   
	    public WebDriverManager getWebDriverManager() {
		      return app;   
	       }
	   
	   
	   public HomePage getHomePage() {
		   if(homePage == null)
			   homePage=new HomePage(app);
		   
		   return homePage;
	   }
	   
	   
	    public LoginPage getLoginPage() {
		      if(loginPage == null)
			   loginPage=new LoginPage(app);
		      return loginPage;
	}
}
