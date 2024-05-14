package PageObjectsModel.PageObjects;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class EventListeners implements ITestListener{
	String path;
	ExtentTest test;
	UIHelper helper = new UIHelper();
	ExtentReports extent = ExtentReporterTNG.getReporter();
	public void onTestStart(ITestResult result) {
	  test = extent.createTest(result.getMethod().getMethodName());
	  
	  }

	public  void onTestSuccess(ITestResult result) {
	   test.log(Status.PASS, "Action complete");
	  }
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Action Incomplete");
		try {
			String title = helper.getPageTitle();
			 path = helper.takeSnapAndPath(title);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	  }
	
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	


}
