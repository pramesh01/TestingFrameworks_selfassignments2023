package com.zoho.base.pages;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public interface ZohoPage extends ZohoSessionPage,ZohoNormalPage {
	
	//zohopage based
	ZohoPage gotoApplicationHomePage();
	void gotoLoginPage();
	ZohoPage gotouserenteringpage();
	//ZohoPage gotopasswordenteringpage();
	ZohoPage gotousernamesubmitpage(String userid);
	ZohoPage gotopasswordsubmitpage(String userid);
	void gotoApplicationDashboard();
	ZohoTestSession getsession();
	WebConnector validator(boolean b);
	WebConnector getDriver();
	
	//Normal page based
	ZohoPage OpenBrowser(String bName);
	void quit();	
	void getTotalWindows();
	void log(String msg);
	
	//Session based
	void CreateDeal();
	void LogOut();
	boolean isExecuteListener();
	void setExecuteListener(boolean executeListener);
}
