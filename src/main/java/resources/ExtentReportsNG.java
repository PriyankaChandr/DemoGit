package resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
		static ExtentReports extent;

		
		public static ExtentReports getReportObject() {
			// ExtentReports,ExtentSparkReporter
			extent = new ExtentReports();
			//String path = System.getProperty("user.dir") + "\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter("reports/index.html");

	//to set reporter name
			reporter.config().setReportName("Automation report");
			reporter.config().setDocumentTitle("Test results");
			
			
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Priyanka");
			return extent;
		}

}
