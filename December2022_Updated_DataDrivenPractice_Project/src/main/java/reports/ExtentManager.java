package reports;
import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	static ExtentReports reports;
	public static String ScreenshotFolderPath;
	
	public static ExtentReports getReports(){
	     if(reports==null){
	     reports=new ExtentReports();
	//reports=new ExtentReports();
	//code for seperate folder
	Date d=new Date();
	//System.out.println(d);
	//System.out.println(d.toString().replace(":","_"));
	String reportsFolder=d.toString().replaceAll(":","_")+"//Screenshots//";			
	ScreenshotFolderPath=System.getProperty("user.dir")+"//Reports//"+reportsFolder;
	String reportstFolderPath=System.getProperty("user.dir")+"//Reports//"+d.toString().replaceAll(":","_");
	System.out.println(ScreenshotFolderPath);
	File f=new File(ScreenshotFolderPath);
	f.mkdirs();
	//code above is for screenshots +logs+directories..		 
	ExtentSparkReporter sparkReporter=new ExtentSparkReporter(reportstFolderPath);
	sparkReporter.config().setReportName("Production Regression Testing");
	sparkReporter.config().setDocumentTitle("Automated Reports");
	//sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setTheme(Theme.STANDARD);
	sparkReporter.config().setEncoding("utf-8");
	reports.attachReporter(sparkReporter);
	//reports.createTest("LoginTest");
	//return the object of the extent test.ExtentTest is internal class.	
}	
return reports;
}			

}
