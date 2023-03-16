package constants;

import org.openqa.selenium.By;

public class Constant {
	
	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="xpath";
	public static final String CSS="css";
	
	public static final String loginLink="/html/body/div[2]/div[2]/div/a[4]";
	public static final String loginLinklocator_xpath="Login_link_xpath";
	
			public static final String username="//*[@id='login_id']";
			public static final By username_locator=By.xpath(username);
			
			public static final String nextButton="//*[@id='nextbtn']";
			public static final  By nextButton_locator=By.xpath(nextButton);
			
			public static final String PasswordTextArea="//*[@id='password']";
			public static final  String PasswordTextArea_locator="PasswordText_xpath";
			
			public static final String LoginButton="//*[@id='nextbtn']/span";
			public static final  By LoginButton_locator=By.xpath(LoginButton);
			
			public static final String HOMEPAGETEXT="//*[@id='block-system-main']/div[1]/div/h1";
			public static final String HomePageText_key="HomePage_Text_xpath";
			
			//title
			public static final String HomePageTitle_key="HomePage_Title";
		 
//reports
			public static final String Reports_Path=System.getProperty("user.dir")+"//Reports//";
			  //columns name in sheet.
		    public static final String TCID_Sheet="TCID";
		    public static final String Runmode_sheet="Runmode";
}
