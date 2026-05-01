package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsReportNG {
	
	public static ExtentReports getObjectReport() {
		
//		String path = System.getProperty("user.dir") + "//test-output//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/index.html");
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Test Results");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Engr", "Scott");
		
		return extent;
		
	}
	

	
}
