package com.zoho.pages.normal;

import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public class LaunchPage extends ZohoBasePage{
	
	public ZohoPage OpenBrowser(String bName) {
		//ZohoTestSession session=getsession();
		//session.getCon().OpenBrowser("bName");
		//getsession().getCon().OpenBrowser(bName);
		log("Opening browser "+bName);
		getDriver().OpenBrowser(bName);
		return this;  //it means return object of its own class i.e LaunchPage;
	 }
	public ZohoPage gotoApplicationHomePage() {
		//System.out.println("open browser - go to application home page Printed");
		//ZohoTestSession session=getsession();
		//session.getCon().navigate("https://www.zoho.com");
		//getsession().getCon().navigate("https://www.zoho.com");
		getDriver().navigate("https://www.zoho.com");
		return new ApplicationHomePage();
	}
}