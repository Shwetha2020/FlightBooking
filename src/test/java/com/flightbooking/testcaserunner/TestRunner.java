package com.flightbooking.testcaserunner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flightbooking.reusablecomponents.ExcelManager;
import com.flightbooking.reusablecomponents.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestRunner extends TestBase {

	@BeforeSuite
	public void beforeSuite() throws Exception {

		initilizedDriver = commonMethods.setDriver(webdriver);
		driver = commonMethods.setWait(initilizedDriver);
		ExcelManager.setExcelFile("Sheet1");
	}

	@BeforeTest
	public void beforetest() {
		ExtentReportManager.setExtentFilePath();
	}

	@Test
	public void onewayTripTestFlow() {
		testCase = "OnewayTrip testcase";
		flightBookingFlow(testCase);
	}

	@Test
	public void roundwayFlightFlow() {
		testCase = "RoundwayTrip testcase";
		flightBookingFlow(testCase);
	}

	public void flightBookingFlow(String testCase) {
		try {
			extenTest = ExtentReportManager.startExtentTest(testCase);
			homePageObject.getUrl(driver, extenTest);
			homePageObject.clickOnRegister(driver, extenTest);
			registerPageObject.enterRegistrationDetails(driver, testCase, extenTest);
			homePageObject.clickOnFlight(driver, extenTest);
			flightPageObject.enterFlightDeatils(driver, extenTest, testCase);
			flightPageObject.selectFlights(driver, extenTest);
			flightPageObject.enterCardDetails(driver, testCase, extenTest);
			commonMethods.printScreen(driver, extenTest);
			homePageObject.logOut(driver, extenTest);
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "positiveTestFlow failed to execute " + e.getLocalizedMessage());
		}
	}

	@Test
	public void registrationNegativeFlow() {
		try {
			testCase = "Registration Negative Testcase";
			extenTest = ExtentReportManager.startExtentTest(testCase);
			homePageObject.getUrl(driver, extenTest);
			homePageObject.clickOnRegister(driver, extenTest);
			registerPageObject.enterRegistrationDetails(driver, testCase, extenTest);
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "registrationNegativeFlow failed to execute " + e.getLocalizedMessage());
		}
	}

	@Test
	public void cardDetailsNegativeFlow() {
		try {
			testCase = "CardDetails Negative Testcase";
			extenTest = ExtentReportManager.startExtentTest(testCase);
			homePageObject.getUrl(driver, extenTest);
			homePageObject.clickOnRegister(driver, extenTest);
			registerPageObject.enterRegistrationDetails(driver, testCase, extenTest);
			homePageObject.clickOnFlight(driver, extenTest);
			flightPageObject.enterFlightDeatils(driver, extenTest, testCase);
			flightPageObject.selectFlights(driver, extenTest);
			flightPageObject.enterNullValuesCardDetails(driver, testCase, extenTest);
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "registrationNegativeFlow failed to execute " + e.getLocalizedMessage());
		}
	}

	@Test
	public void flightDatesNegativeFlow() {
		try {
			testCase = "FlightDates Negative Testcase";
			extenTest = ExtentReportManager.startExtentTest(testCase);
			homePageObject.getUrl(driver, extenTest);
			homePageObject.clickOnRegister(driver, extenTest);
			registerPageObject.enterRegistrationDetails(driver, testCase, extenTest);
			homePageObject.clickOnFlight(driver, extenTest);
			flightPageObject.enterFlightDeatils(driver, extenTest, testCase);
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "registrationNegativeFlow failed to execute " + e.getLocalizedMessage());
		}
	}

	@AfterSuite
	public void afterSuite() {
		extentReportManager.getExtentReport();
		driver.close();
		driver.quit();

	}

}
