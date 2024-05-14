package PageObjectsModel.PageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;

public class ExtentReporterTNG {

	public static ExtentReports getReporter() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("/Users/Sebastian/Desktop/EclipseWorkspace3/TestNGDemo/index.html");
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Web Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
}
