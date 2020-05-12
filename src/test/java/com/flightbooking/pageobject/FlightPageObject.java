package com.flightbooking.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.flightbooking.pageLocators.FlightPageLocators;
import com.flightbooking.reusablecomponents.CommonMethods;
import com.flightbooking.reusablecomponents.ExcelManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FlightPageObject extends FlightPageLocators {
	CommonMethods commonMethods = new CommonMethods();
	Select select;

	public void enterFlightDeatils(WebDriver driver, ExtentTest extenTest, String testCase) {
		try {
			String flightType = ExcelManager.getCellDataValue("flightType", testCase);
			if (flightType.equals("roundtripFlight")) {
				driver.findElement(roundtripFlight).click();
			} else {
				driver.findElement(onewayFlight).click();
			}
			select = commonMethods.selectClass(driver.findElement(numOfPassergers));
			select.selectByVisibleText("2");
			select = commonMethods.selectClass(driver.findElement(fromPort));
			select.selectByVisibleText("Frankfurt");
			select = commonMethods.selectClass(driver.findElement(fromMonth));
			select.selectByVisibleText("February");
			String onDate = ExcelManager.getCellDataValue("onDate", testCase);
			select = commonMethods.selectClass(driver.findElement(fromDay));
			select.selectByVisibleText(onDate);
			select = commonMethods.selectClass(driver.findElement(toPort));
			select.selectByVisibleText("London");
			select = commonMethods.selectClass(driver.findElement(toMonth));
			select.selectByVisibleText("April");
			String ReturnDate = ExcelManager.getCellDataValue("ReturnDate", testCase);
			select = commonMethods.selectClass(driver.findElement(toDay));
			select.selectByVisibleText(ReturnDate);

			driver.findElement(businessClass).click();
			select = commonMethods.selectClass(driver.findElement(airline));
			select.selectByVisibleText("Blue Skies Airlines");

			driver.findElement(findFlights).click();
			boolean flag = true;
			if (Integer.parseInt(onDate) <= Integer.parseInt(ReturnDate)) {
				extenTest.log(LogStatus.PASS, "FlightDateVerification is successful executed");
			} else {
				flag = false;
				//extenTest.log(LogStatus.FAIL, "Negative testcase for FlightDateVerification failed");
				throw new Exception("Negative testcase for FlightDateVerification failed");
			}

			if (flightType.equals("onewayFlight")) {
				if (!driver.findElement(onewayFlightVerification).isDisplayed()) {
					extenTest.log(LogStatus.PASS, "onewayFlightVerification is successful executed");
				} else {
					extenTest.log(LogStatus.FAIL, "onewayFlightVerification failed");
				}
			}
			if (flag == true) {
				if (driver.findElements(outFlights).size() > 0) {
					extenTest.log(LogStatus.PASS, "enterFlightDeatils is successful executed");
				} else {
					extenTest.log(LogStatus.FAIL, "enterFlightDeatils failed to execute");
				}
			}
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "enterFlightDeatils failed to execute", e.getMessage());
		}
	}

	public void selectFlights(WebDriver driver, ExtentTest extenTest) {
		try {
			List<WebElement> outFlightElements = driver.findElements(outFlights);
			outFlightElements.get(2).click();

			List<WebElement> inFlightElements = driver.findElements(inFlights);
			inFlightElements.get(3).click();

			driver.findElement(reserveFlights).click();
			if (driver.findElement(buyFlightTickets).isDisplayed()) {
				extenTest.log(LogStatus.PASS, "selectFlights is successful executed");
			} else {
				extenTest.log(LogStatus.FAIL, "selectFlights failed to execute");
			}
		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "selectFlights failed to execute", e.getMessage());
		}
	}

	public void enterCardDetails(WebDriver driver, String testCase, ExtentTest extenTest) throws Exception {
		try {
			driver.findElement(firstNamePassenger1)
					.sendKeys(ExcelManager.getCellDataValue("firstNamePassenger1", testCase));
			driver.findElement(lastNamePassenger1)
					.sendKeys(ExcelManager.getCellDataValue("lastNamePassenger1", testCase));
			select = commonMethods.selectClass(driver.findElement(mealPreferancePassenger1));
			select.selectByVisibleText(ExcelManager.getCellDataValue("mealPreferancePassenger1", testCase));
			driver.findElement(firstNamePassenger2)
					.sendKeys(ExcelManager.getCellDataValue("firstNamePassenger2", testCase));
			driver.findElement(lastNamePassenger2)
					.sendKeys(ExcelManager.getCellDataValue("lastNamePassenger2", testCase));
			select = commonMethods.selectClass(driver.findElement(mealPreferancePassenger2));
			select.selectByVisibleText(ExcelManager.getCellDataValue("mealPreferancePassenger2", testCase));

			commonMethods.selectClass(driver.findElement(creditCard))
					.selectByVisibleText(ExcelManager.getCellDataValue("creditCard", testCase));
			driver.findElement(creditnumber).sendKeys(ExcelManager.getCellDataValue("creditnumber", testCase));
			commonMethods.selectClass(driver.findElement(cardExpirationMonth))
					.selectByVisibleText(ExcelManager.getCellDataValue("cardExpirationMonth", testCase));
			commonMethods.selectClass(driver.findElement(cardExpirationYear))
					.selectByVisibleText(ExcelManager.getCellDataValue("cardExpirationYear", testCase));
			driver.findElement(cardFirstName).sendKeys(ExcelManager.getCellDataValue("cardFirstName", testCase));
			driver.findElement(cardMiddleName).sendKeys(ExcelManager.getCellDataValue("cardMiddleName", testCase));
			driver.findElement(cardLastName).sendKeys(ExcelManager.getCellDataValue("cardLastName", testCase));

			driver.findElement(billAddress).clear();
			driver.findElement(billAddress).sendKeys(ExcelManager.getCellDataValue("billAddress", testCase));
			driver.findElement(billCity).clear();
			driver.findElement(billCity).sendKeys(ExcelManager.getCellDataValue("billCity", testCase));
			driver.findElement(billState).clear();
			driver.findElement(billState).sendKeys(ExcelManager.getCellDataValue("billState", testCase));
			driver.findElement(billZip).clear();
			driver.findElement(billZip).sendKeys(ExcelManager.getCellDataValue("billZip", testCase));
			commonMethods.selectClass(driver.findElement(billCountry))
					.selectByVisibleText(ExcelManager.getCellDataValue("billCountry", testCase));

			driver.findElement(delAddress).clear();
			driver.findElement(delAddress).sendKeys(ExcelManager.getCellDataValue("delAddress", testCase));
			driver.findElement(delCity).clear();
			driver.findElement(delCity).sendKeys(ExcelManager.getCellDataValue("delCity", testCase));
			driver.findElement(delState).clear();
			driver.findElement(delState).sendKeys(ExcelManager.getCellDataValue("delState", testCase));
			driver.findElement(delZip).clear();
			driver.findElement(delZip).sendKeys(ExcelManager.getCellDataValue("delZip", testCase));
			commonMethods.selectClass(driver.findElement(delCountry))
					.selectByVisibleText(ExcelManager.getCellDataValue("delCountry", testCase));
			if (ExcelManager.getCellDataValue("delCountry", testCase) != "UNITED STATES ") {
				driver.switchTo().alert().accept();
			}
			driver.findElement(buyFlightTickets).click();
			boolean flag = false;

			if (ExcelManager.getCellDataValue("creditnumber", testCase).length() != 11) {
				flag = driver.findElement(bookingVerification).isDisplayed();
				if (flag == false) {
					
					extenTest.log(LogStatus.PASS, "verification for creditnumber length for enterCardDetails is successfully executed");
				} else {
					//extenTest.log(LogStatus.FAIL, "verification for creditnumber length for of enterCardDetails is failed");
					throw new Exception("verification for creditnumber length for of enterCardDetails is failed");
				}
			}
			if (flag == false) {

				if (driver.findElement(bookingVerification).isDisplayed()) {
					extenTest.log(LogStatus.PASS, "enterCardDetails is successful executed");
				} else {
					extenTest.log(LogStatus.FAIL, "enterCardDetails failed to execute");
				}
			}

		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "enterCardDetails failed to execute", e.getMessage());
		}
	}

	public void enterNullValuesCardDetails(WebDriver driver, String testCase, ExtentTest extenTest) throws Exception {
		try {

			driver.findElement(buyFlightTickets).click();
			if (!driver.findElement(bookingVerification).isDisplayed()) {
				extenTest.log(LogStatus.PASS, "Negative testcase with null enterCardDetails is successfully executed");
			} else {
				extenTest.log(LogStatus.FAIL, "Negative testcase with null CardDetails is failed");
			}

		} catch (Exception e) {
			extenTest.log(LogStatus.FAIL, "Negative testcase for enterCardDetails failed to execute", e.getMessage());
		}
	}

}
