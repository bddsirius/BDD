package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoRegistrationDetailsPage extends RegistrationDetailsPage{
	
	@FindBy(name = "phone1")
	private BaseElement phoneInput;
	
	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_email1_In_Register_1")
	private BaseElement emailInput; 
	
	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1")
	private BaseElement passwordInput;
	
	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1")
	private BaseElement passwordConfirmInput;
	
	@FindBy(id = "submitButton")
	private BaseElement speedoSubmit;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoRegistrationDetailsPage.class);
	
	/**
	 * Method to enter value in the email field
	 * @param email - Email Address
	 */
	public void enterEmail(String email) {
		LOGGER.info("Entering email: " + email);
		emailInput.type(email);
	}
	
	/** 
	 * Method to enter value in password field
	 * @param password - Password
	 */
	public void enterPassword(String password) {
		LOGGER.info("Entering password: "+ password);
		passwordInput.type(password);
	}
	
	/**
	 * Method to enter value in confirm password field
	 * @param password - Password
	 */
	public void enterConfirmPassword(String password) {
		LOGGER.info("Entering confirm password: " + password);
		passwordConfirmInput.type(password);
	}
	
	/**
	 * Method to click submit button
	 */
	public void clickSubmit() {
		LOGGER.info("Clicking submit");
		speedoSubmit.click();
	}
	
	/**
	 * Method to enters value in phone field
	 */
	public void enterPhone(String phone) {
		LOGGER.info("Entering phone: " + phone);
		phoneInput.type(phone);
	}
	
	/**
	 * Method to enter Speedo registration details
	 * @param email - Email Address
	 * @param password - Password
	 * @param fName - First Name
	 * @param lName - Last Name
	 * @param phone - Phone Number
	 */
	public void fillOutRegistration(String email, String password, String fName, String lName, String phone) {
		enterEmail(email);
		enterPassword(password);
		enterConfirmPassword(password);
		enterFirstName(fName);
		enterLastName(lName);
		enterPhone(phone);
		clickSubmit();
	}
	
	@Override
	/**
	 * Method to verify Speedo Registration detail page title
	 */
	public void verifyPageTitle() {
		String title = this.getTitle(); 
		assertThat(title).as("Regiration Details Page Title").isEqualTo("Register | Speedo USA");
	}
	
}