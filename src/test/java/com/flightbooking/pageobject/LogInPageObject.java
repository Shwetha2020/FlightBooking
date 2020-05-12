package com.flightbooking.pageobject;

import org.openqa.selenium.WebDriver;

import com.flightbooking.pageLocators.LogInPageLocators;
import com.flightbooking.reusablecomponents.ExcelManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogInPageObject extends LogInPageLocators{

	public void logInWithRegisteredUser(WebDriver driver,String testCase,ExtentTest extenTest) throws Exception {
		try {
		driver.findElement(userName).sendKeys(ExcelManager.getCellDataValue("userName", testCase));
		driver.findElement(password).sendKeys(ExcelManager.getCellDataValue("password", testCase));
		driver.findElement(login).click();
		}catch(Exception e) {
			extenTest.log(LogStatus.FAIL, "clickOnRegister failed to execute", e.getMessage());
		}
	}
	
}
