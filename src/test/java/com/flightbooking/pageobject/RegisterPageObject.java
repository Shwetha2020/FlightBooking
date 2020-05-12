package com.flightbooking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flightbooking.pageLocators.HomePageLocators;
import com.flightbooking.pageLocators.RegisterPageLocators;
import com.flightbooking.reusablecomponents.ExcelManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegisterPageObject extends RegisterPageLocators{
	
	public void enterRegistrationDetails(WebDriver driver,String testCase,ExtentTest extenTest) {
		try {
		driver.findElement(firstName).sendKeys(ExcelManager.getCellDataValue("firstName", testCase));
		driver.findElement(lastName).sendKeys(ExcelManager.getCellDataValue("lastName", testCase));
		driver.findElement(phoneNum).sendKeys(ExcelManager.getCellDataValue("phone", testCase));
		driver.findElement(email).sendKeys(ExcelManager.getCellDataValue("email", testCase));
		driver.findElement(address1).sendKeys(ExcelManager.getCellDataValue("address", testCase));
		driver.findElement(city).sendKeys(ExcelManager.getCellDataValue("city", testCase));
		driver.findElement(state).sendKeys(ExcelManager.getCellDataValue("state", testCase));
		driver.findElement(postalCode).sendKeys(ExcelManager.getCellDataValue("postalCode", testCase));
		driver.findElement(country).sendKeys(ExcelManager.getCellDataValue("country", testCase));
		driver.findElement(userName).sendKeys(ExcelManager.getCellDataValue("userName", testCase));
		driver.findElement(password).sendKeys(ExcelManager.getCellDataValue("password", testCase));
		driver.findElement(confirmPassword).sendKeys(ExcelManager.getCellDataValue("confirmPassword", testCase));
		
		driver.findElement(submitRegister).click();
		boolean flag = false;
		if(ExcelManager.getCellDataValue("userName", testCase).equals("")) {
			flag =driver.findElement(HomePageLocators.logOut).isDisplayed();
			if(flag==false) {
				extenTest.log(LogStatus.PASS, "Negative testcase of null values for registration is successfully executed");
			}else {
				//extenTest.log(LogStatus.FAIL,"Negative testcase of null values for registration registration is failed");
				throw new Exception("Negative testcase of null values for registration registration is failed");
			}
		}
		if(flag==false) {
		if(driver.findElement(HomePageLocators.logOut).isDisplayed()) {
			extenTest.log(LogStatus.PASS, "enterRegistrationDetails is successful executed");
		}else {
			extenTest.log(LogStatus.FAIL, "enterRegistrationDetails failed to execute");
		}
		}
		}catch(Exception e) {
			extenTest.log(LogStatus.FAIL, "enterRegistrationDetails failed to execute", e.getMessage());
		}
	}
}
