package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyTestListener implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		System.out.println("*****Listeners-onFailure "+result.getName());
		//System.out.println(result.getThrowable().getMessage());
		ExtentTest test=(ExtentTest) result.getTestContext().getAttribute("test");
		test.log(Status.FAIL,result.getThrowable().getMessage());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("*****Listeners-onSuccess "+result.getName());
		//System.out.println(result.getThrowable().getMessage());
		ExtentTest test=(ExtentTest) result.getTestContext().getAttribute("test");
		test.log(Status.PASS,result.getName()+"--Test success");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("*****Listeners-onSkipped "+result.getName());
		//System.out.println(result.getThrowable().getMessage());
		ExtentTest test=(ExtentTest) result.getTestContext().getAttribute("test");
		test.log(Status.SKIP,result.getName()+"--test skipped");
	}

}
