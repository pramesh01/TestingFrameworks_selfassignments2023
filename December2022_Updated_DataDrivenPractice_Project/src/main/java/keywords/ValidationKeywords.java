package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class ValidationKeywords extends GenericKeywords{
	
	public void validateTitle() {
		
	}
	public void validateText() {
		
	}
	public void validateElementPresent(String locator) {
		boolean result=isElementPresent(locator);
		test.log(Status.INFO,"verifying if the LogOut button is available or not");
		if(!result)
			reportFailure("not logged in successfully",true);
		//System.out.println("element "+result+" is present.");
		//reportFailure("element is not present thats why it is failing.",false);
		
	}
	
	public void validateLoginSuccessful(String locatorKey) {
	System.out.println("verifying the element is available or not after login.");
	validateElementPresent(locatorKey);
	//getElement(prop.getProperty(locatorKey));	
	}
	
	   public void validateSelectedValueInDropDown(String locatorKey,String option) {
	    	Select s=new Select(getElement(locatorKey));
	    	String text=s.getFirstSelectedOption().getText();
	    	if(! text.equals(option)) {
	    		logFailure(option +" is not available in drop down list.",true);
	    	}
	    }
	   
	   public void validateSelectedValueNotInDropDown(String locatorKey,String option) {
	    	Select s=new Select(getElement(locatorKey));
	    	String text=s.getFirstSelectedOption().getText();
	    	if(text.equals(option)) {
	    		logFailure(option +" is not available in drop down list.",true);
	    	}
	    }

}
