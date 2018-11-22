package com.qualitest.pvh.pages;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THShippingPage extends ShippingPage{

	private static final Logger LOGGER = LoggerFactory.getLogger(THShippingPage.class); 

	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_country_1")
	private BaseElement countrySelect;
	
	@FindBy(id="continueGuest")
	private BaseElement continueGuest;
	
	/**
	 * Method to select provided value in country field
	 * @param country - Country
	 */
	public void selectCountry(String country) {
		LOGGER.info("Selecting country: " + country);
		Select roledropdown = new Select(countrySelect);
		roledropdown.selectByVisibleText(country);
	}

	public void enterGuestFieldsAndSubmit(String email, String first, String last, String address, String apartment, String city, String state, String country, String zip, String phone) {
		enterEmail(email);
		clickEnterManual();
		enterFirstName(first);
		enterLastName(last);
		if(!address.equals("")) {
			enterAddress(address);
		}
		enterApartment(apartment);
		enterCity(city);
		selectCountry(country);
		selectState(state);
		enterZip(zip);
		enterPhone(phone);
		clickAddressNext();
	}
	
	/**
	 * Method to enter and submit address
	 * @param guestFields - Address Details email;first name;last name;address line 1;apartment;city;country;state;zip code;phone number
	 */
	public void enterAddressAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 10) {
			LOGGER.info("Incomplete address information provided");
		}
		enterEmail(arr[0]);
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		clickEnterManual();
		enterFirstName(arr[1]);
		
		clickOffPopUp();
		
		enterLastName(arr[2]);
		if(!arr[3].equals(" ")) {
			enterAddress(arr[3]);
		}
		if(!arr[4].equals(" ")) {
			enterApartment(arr[4]);
		}
		enterCity(arr[5]);
		selectCountry(arr[7]);
		selectState(arr[6]);
		enterZip(arr[8]);
		enterPhone(arr[9]);
		if(continueGuest.exists()) {
			continueGuest.click();
		}
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		clickAddressNext();
	}
	
}
