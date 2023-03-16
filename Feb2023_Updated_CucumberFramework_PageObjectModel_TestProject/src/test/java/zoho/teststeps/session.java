package zoho.teststeps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import zoho.context.TestContext;
import zoho.pages.HomePage;
import zoho.pages.LoginPage;

public class session {
	public HomePage homepage;
	public LoginPage loginPage;
	public TestContext context;
	
	public session(TestContext context) {
		System.out.println("inside session constructor.");
		this.context=context;
		this.homepage=this.context.getPageObjectManager().getHomePage();
		this.loginPage=this.context.getPageObjectManager().getLoginPage();
	  }
	 
	  @Given ("i am logging into website https://zoho.com")
	      public void website() {
		  context.log("navigating to the website https://zoho.com");
		  homepage.load("chrome");
		  homepage.gotologinpage();
		  loginPage.doLogin();
		  
		     }
       
      @When("i goto {string} page")
           public void createleadpage(String pages) {
    	   context.log("going to page "+pages);
                 }  
                    } 
