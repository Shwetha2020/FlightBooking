package com.flightbooking.reusablecomponents;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportManager {
	
	static ExtentReports extentReport=null;
	public static ExtentTest extenTest=null; 
	
	
	public static void setExtentFilePath() {
		extentReport = new ExtentReports(System.getProperty("user.dir")
				+"\\reports\\ExtentReport_"+CommonMethods.dateFormat.format(new Date())+".html");
	}
	
	public static ExtentTest startExtentTest(String testcase) {
		extenTest = extentReport.startTest(testcase);
		return extenTest;
	}
	
	public void getExtentReport() {
		extentReport.endTest(extenTest);
		extentReport.flush();
	}
	
	
}
