package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateReport {

	public static ExtentTest test;
	static ExtentReports report;

	public GenerateReport() {
		// TODO Auto-generated constructor stub
	}

	public static ExtentTest generateExtentReports(String project,String testName) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = formatter.format(date);
		
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		String day = formatter2.format(date);
		

		String userDir = System.getProperty("user.home");
		String reportPath = userDir + "/eclipse-workspace/" + project + "/reports/" + timestamp +"/Reports.html";
		
//		String reportPath = userDir + "/Desktop/"+day+"/reports/"+testName+"/"+timestamp+"/Reports.html";
		
		report = new ExtentReports(reportPath);

		test = report.startTest(testName);

		return test;
	}
	
	public static void closeExtentReports() {
		report.endTest(test);
		report.flush();
	}

	public static void test(LogStatus pass, String string) {
		// TODO Auto-generated method stub
		
	}

}
