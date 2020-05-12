package com.flightbooking.pageLocators;

import org.openqa.selenium.By;

public class LogInPageLocators {
	
	RegisterPageLocators registerPageLocators = new RegisterPageLocators();
	
	public static By signIn = By.linkText("SIGN-ON");
	public static By userName = RegisterPageLocators.email;
	public static By password = RegisterPageLocators.password;
	public static By login = By.name("login");
	
	
}
