package com.flightbooking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flightbooking.pageLocators.HomePageLocators;
import com.flightbooking.pageLocators.RegisterPageLocators;
import com.flightbooking.reusablecomponents.ExtentReportManager;
import com.flightbooking.testcaserunner.TestBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageObject extends HomePageLocators {

	public void getUrl(WebDriver driver, ExtentTest extenTest) {
		try {
			String url = "http://newtours.demoaut.com";
			driver.get(url);
			System.out.println(driver.getTitle());
			if (driver.getTitle().equals("Welcome: Mercury Tours")) {
				extenTest.log(LogStatus.PASS, "getUrl " + url + " is successful executed");
			} else
				extenTest.log(LogStatus.FAIL, "getUrl " + url + " failed to execute");
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "getUrl failed to execute", e.getMessage());
		}
	}

	public void clickOnRegister(WebDriver driver, ExtentTest extenTest) {
		try {
			driver.findElement(register).click();
			if (driver.findElement(RegisterPageLocators.confirmPassword).isDisplayed()) {
				extenTest.log(LogStatus.PASS, "clickOnRegister is successful executed");
			} else {
				extenTest.log(LogStatus.FAIL, "clickOnRegister failed to execute");
			}
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "clickOnRegister failed to execute", e.getMessage());
		}
	}

	public void logOut(WebDriver driver, ExtentTest extenTest) {
		try {
			driver.findElement(logOut).click();
			if (driver.findElement(By.linkText("SIGN-ON")).isDisplayed()) {
				extenTest.log(LogStatus.PASS, "logOut is successful executed");
			} else {
				extenTest.log(LogStatus.FAIL, "logOut failed to execute");
			}
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "logOut failed to execute", e.getMessage());
		}
	}

	public void clickOnFlight(WebDriver driver, ExtentTest extenTest) {
		try {
			driver.findElement(flight).click();
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "clickOnFlight failed to execute", e.getMessage());
		}
	}
}
