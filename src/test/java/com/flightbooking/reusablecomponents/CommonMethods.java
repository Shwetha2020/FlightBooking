package com.flightbooking.reusablecomponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods {
	static Select select;
    public static SimpleDateFormat dateFormat;
	
	static {
		dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	
	public WebDriver setDriver(WebDriver driver){
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();	
		return driver;
	}
	
	public WebDriver setWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public Select selectClass(WebElement element) {
		select = new Select(element);
		return select;	
	}
	
	public void printScreen(WebDriver driver,ExtentTest extenTest) throws IOException {
		try {
		TakesScreenshot  screenshot= ((TakesScreenshot)driver);
		File scrLocation = screenshot.getScreenshotAs(OutputType.FILE);
		File destLocation = new File("./screenshot/screenshot"+dateFormat.format(new Date())+".png");
		FileHandler.copy(scrLocation, destLocation);
		}catch(Exception e) {
			extenTest.log(LogStatus.FAIL, "printScreen failed to execute", e.getMessage());
		}
	}
	
	

}
