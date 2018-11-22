package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoShippingPage extends ShippingPage {
	
	@FindBy(id="continueGuest")
	private BaseElement continueGuest;
	
	@FindBy(xpath = "//*[@id = 'discountDetailsSection']")
	private BaseElement promoDiscountDetails;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(SpeedoShippingPage.class); 

	/**
	 * Enter the attributes that are needed for address fields
	 * @param email
	 * @param first
	 * @param last
	 * @param address
	 * @param apartment
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public void enterGuestFieldsAndSubmit(String email, String first, String last, String address, String apartment, String city, String state, String zip, String phone) {
		enterEmail(email);
		clickEnterManual();
		enterFirstName(first);
		enterLastName(last);
		if(!address.equals("")) {
			enterAddress(address);
		}
		enterApartment(apartment);
		enterCity(city);
		selectState(state);
		enterZip(zip);
		enterPhone(phone);
		clickAddressNext();
	}
	
	public void clearFirstName() {
		LOGGER.info("Clearing first name");
		firstNameInput.clear();
	}
	
	public void clearLastName() {
		LOGGER.info("Clearing last name");
		lastNameInput.clear();
	}
	
	public void clearPhoneNumber() {
		LOGGER.info("Clearing phone number");
		phoneInput.clear();
	}
	
	/**
	 * This one takes in a String of all fields seperated by delimiters
	 * @param guestFields
	 */
	public void enterGuestFieldsAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 10) {
			LOGGER.info("There is an issue where not all fields have been submitted");
		}
		enterEmail(arr[0]);
		clickEnterManual();
		enterFirstName(arr[1]);
		enterLastName(arr[2]);
		if(!arr[3].equals(" ")) {
			enterAddress(arr[3]);
		}
		if(!arr[4].equals(" ")) {
			enterApartment(arr[4]);
		}
		enterCity(arr[5]);
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
	
	public void enterEditFieldsAndSubmit(String editFields) {
		String[] arr = editFields.split(";");
		if(arr.length != 10) {
			LOGGER.info("There is an issue where not all fields have been submitted");
		}
		clickEnterManual();
		clearFirstName();
		enterFirstName(arr[1]);
		clearLastName();
		enterLastName(arr[2]);
		if(!arr[3].equals(" ")) {
			enterAddress(arr[3]);
		}
		if(!arr[4].equals(" ")) {
			enterApartment(arr[4]);
		}
		enterCity(arr[5]);
		selectState(arr[6]);
		enterZip(arr[8]);
		clearPhoneNumber();
		enterPhone(arr[9]);
		
	}
	
	private boolean isPromoCodeApplied() {
		boolean isThere =false;
		if(promoDiscountDetails.isVisible()) {
			isThere = true;
		}
		LOGGER.info("The promo code is applied: "+isThere);
		return isThere;
	}
	
	@Override
	public void verifyPromoCodeAppliedOnCheckout() {
		assertThat(isPromoCodeApplied()).as("Promo code is applied").isTrue();
	}
	
	@Override
	public void verifyPromoCodeAppliedAndRemovedOnCheckout() {
		SA.assertThat(isPromoCodeApplied()).as("Promo code is applied").isTrue();
		clickRemovePromo();
		SA.assertThat(isPromoCodeApplied()).as("Promo code is not applied").isFalse();
		SA.assertAll();
	}
}
