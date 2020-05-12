package com.flightbooking.pageLocators;

import org.openqa.selenium.By;

public class FlightPageLocators {

	public static By onewayFlight = By.xpath("//input[@value='oneway']");
	public static By roundtripFlight = By.xpath("//input[@value='roundtrip']");
	public static By numOfPassergers = By.name("passCount");
	public static By fromPort = By.name("fromPort");
	public static By fromMonth = By.name("fromMonth");
	public static By fromDay = By.name("fromDay");
	public static By toPort = By.name("toPort");
	public static By toMonth = By.name("toMonth");
	public static By toDay = By.name("toDay");
	public static By businessClass = By.xpath("//input[@value='Business']");
	public static By airline = By.name("airline");
	public static By findFlights = By.name("findFlights");	
	
	public static By outFlights = By.xpath("//input[@name='outFlight']");
	public static By inFlights = By.xpath("//input[@name='inFlight']");
	public static By reserveFlights = By.name("reserveFlights");
	
	public static By firstNamePassenger1 = By.name("passFirst0");
	public static By lastNamePassenger1 = By.name("passLast0");
	public static By mealPreferancePassenger1 = By.name("pass.0.meal");
	public static By firstNamePassenger2 = By.name("passFirst1");
	public static By lastNamePassenger2 = By.name("passLast1");
	public static By mealPreferancePassenger2 = By.name("pass.1.meal");
	public static By creditCard = By.name("creditCard");
	public static By creditnumber = By.name("creditnumber");
	public static By cardExpirationMonth = By.name("cc_exp_dt_mn");
	public static By cardExpirationYear = By.name("cc_exp_dt_yr");
	public static By cardFirstName = By.name("cc_frst_name");
	public static By cardMiddleName = By.name("cc_mid_name");
	public static By cardLastName = By.name("cc_last_name");
	public static By billAddress = By.name("billAddress1");
	public static By billCity = By.name("billCity");
	public static By billState = By.name("billState");
	public static By billZip = By.name("billZip");
	public static By billCountry = By.name("billCountry");
	public static By delAddress = By.name("delAddress1");
	public static By delCity = By.name("delCity");
	public static By delState = By.name("delState");
	public static By delZip = By.name("delZip");
	public static By delCountry = By.name("delCountry");
	public static By buyFlightTickets = By.name("buyFlights");
	public static By bookingVerification = By.xpath("//font[contains(text(),'itinerary has been booked!')]");
	public static By onewayFlightVerification = By.xpath("//font[contains(text(),'RETURN')]");
	
	
}
