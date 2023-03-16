package com.zoho.base.pages;

import com.zoho.web.WebConnector;

public interface ZohoNormalPage {
	
	ZohoPage OpenBrowser(String bName);
	void quit();
	void getTotalWindows();
	WebConnector validator(boolean stopExecution);
  }
