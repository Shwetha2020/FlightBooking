package com.flightbooking.testcaserunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.flightbooking.pageobject.FlightPageObject;
import com.flightbooking.pageobject.HomePageObject;
import com.flightbooking.pageobject.LogInPageObject;
import com.flightbooking.pageobject.RegisterPageObject;
import com.flightbooking.reusablecomponents.CommonMethods;
import com.flightbooking.reusablecomponents.ExcelManager;
import com.flightbooking.reusablecomponents.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	WebDriver webdriver;
	WebDriver driver;
	WebDriver initilizedDriver;
	
	RegisterPageObject registerPageObject = new RegisterPageObject();
	HomePageObject homePageObject = new HomePageObject();
	CommonMethods commonMethods = new CommonMethods();
	LogInPageObject logInPageObject = new LogInPageObject();
	FlightPageObject flightPageObject = new FlightPageObject();
	ExtentReportManager extentReportManager = new ExtentReportManager();
	
	
	String testCase;
	public static ExtentReports extentReport;
	public static ExtentTest extenTest;
	
	
}
