package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports(); //class which is provided by aventstack to generate report

	public synchronized static ExtentReports createExtentReports() {
		//location of the HTML report is provided by below class															
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // ./extent-reports ==>directory(folder),extent-reports(file)
		
		reporter.config().setReportName("7martsupermarket"); // config().setReportName("7RMart Project") 2 methods in
																// ExtentSparkReporter
		extentReports.attachReporter(reporter); // attaching od extend report and extendssparkrep for report generation
		extentReports.setSystemInfo("Organization", "Obsqura"); // org name
		extentReports.setSystemInfo("Name", "Glossy");// team member name
		return extentReports; // createExtentReports() returns extentReports
	}
}
