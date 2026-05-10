package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsReportNG {
	
	public ExtentReports getObjectReport() {

	    String reportName = System.getProperty("reportName", "DefaultReport");

	    String path = System.getProperty("user.dir")
	            + "//reports//"
	            + reportName
	            + ".html";

	    ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	    reporter.config().setReportName("Web Automation Report");
	    reporter.config().setDocumentTitle("Test Results");

	    ExtentReports extent = new ExtentReports();

	    extent.attachReporter(reporter);

	    extent.setSystemInfo("QA Engr", "Scott");

	    return extent;
	}
	

	
}
