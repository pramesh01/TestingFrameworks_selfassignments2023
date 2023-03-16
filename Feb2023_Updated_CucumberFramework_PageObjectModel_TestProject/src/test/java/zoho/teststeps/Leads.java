package zoho.teststeps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zoho.context.TestContext;

public class Leads {
	
	public TestContext context;
	
	public Leads(TestContext context) {
		System.out.println("inside leads constructor.");
		this.context=context;
	  }
	
	@Before
	public void before(Scenario s) {
		//System.out.println("starting scenario is "+s.getName());
		context.createScenario(s.getName());
		context.log("starting scenario is "+s.getName());
	}
	@After
	public void after(Scenario s) {
		context.log("ending the scenario "+s.getName());
		context.endScenario();
		context.getPageObjectManager().getWebDriverManager().finished();
		System.out.println("-------------------------------------");
		}
	
	@Then("i verify the lead details")
    public void verifyDetails() {
	   context.log("i verify the Lead details");
	       }

@And ("lead should be present inside the grid")
     public void verifyingrid() {
	    context.log(" inside the grid lead should be present.");
	       }


    @And("enter and submit the lead details")
     public void enteringdetails() {
      context.log("entering and submitting the Leads details ");
       }

    @And ("i goto the {string} page")
      public void detailslead(String details) {
       context.log("going to the "+details+ " page");    	   
        }
    //deleting the leads.
    
    @When ("I select the lead")
      public void selectinglead() {
    	context.log("selecting the leads..");
      }
    
    @And("I click on delete button")
      public void deletebutton() {
       context.log("clicking on the delete button");	
       }
    
    @Then ("Lead should be deleted")
       public void verifydeletedleadinlist() {
    	context.log("lead should be deleted.");
          
           }
          }

