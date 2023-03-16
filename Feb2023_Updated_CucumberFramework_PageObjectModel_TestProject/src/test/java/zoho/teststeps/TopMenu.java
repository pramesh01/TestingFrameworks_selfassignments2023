package zoho.teststeps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import zoho.context.TestContext;

public class TopMenu {
	
public TestContext context;
	
	public TopMenu(TestContext context) {
		System.out.println("inside TopMenu constructor.");
		this.context=context;
	  }

	@And("i click on {string} tab on top menu")
         public void leadsTab(String tabontop) {
	     context.log("clicking on "+tabontop+" on top grid menu list");
	   
	      }
            }
