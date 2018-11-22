package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class PersonalInformationPage extends BasePage{
		
	@FindBy(id="WC_UserRegistrationUpdateForm_FormInput_logonPasswordOld_In_Register_1")
	private BaseElement currPassword;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_FormInput_logonPassword_In_Register_1")
	private BaseElement newPassword;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_FormInput_logonPasswordVerify_In_Register_1")
	private BaseElement confirmNewPassword;
	
	@FindBy(css="#Register > div.clearfix > div.button_footer_line.clearfix > #WC_UserRegistrationUpdateForm_links_1")
	private BaseElement update;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1")
	private BaseElement firstName;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1")
	private BaseElement lastName;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1")
	private BaseElement address;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address2_1")
	private BaseElement apartment;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1")
	private BaseElement city;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_country_1")
	private BaseElement countrySelect;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_state_1")
	private BaseElement stateSelect;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1")
	private BaseElement zipCode;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_FormInput_phoneNum_In_Register_1")
	private BaseElement phone;
	
	@FindBy(id="pageLevelMessage")
	private BaseElement pageLevelMessage;
	
	@FindBy(xpath = "//*[contains( text(), 'Enter your address manually')]")
	private BaseElement enterAddressManual;
	
	@FindBy(xpath = "//div[@id = 'page']/*[@id = 'pageLevelMessage']")
	private BaseElement pageLevelError;
	
	@FindBy(xpath = "//*[@id= 'fieldErrorMessage']")
	private BaseElement fieldLevelError;
	
	private SoftAssertions SA = new SoftAssertions();
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonalInformationPage.class);
	
	/**
	 * Method to enter value in current password field
	 * @param input - Current Password
	 */
	private void inputCurrPassword(String input) {
		LOGGER.info("Entering Current Password: " + input);
		currPassword.sendKeys(input);
	}
	
	/**
	 * Method to enter value in new password field
	 * @param input - New Password
	 */
	private void inputNewPassword(String input) {
		LOGGER.info("Entering New Password: " + input);
		newPassword.sendKeys(input);
	}
	
	/**
	 * Method to enter value in confirm password field
	 * @param input - Confirm Password
	 */
	private void inputConfirmPassword(String input) {
		LOGGER.info("Entering Confirm Password: " + input);
		confirmNewPassword.sendKeys(input);
	}
	
	/**
	 * Clicking update button
	 */
	private void clickUpdate() {
		LOGGER.info("Clicking update button");
		update.click();
		try {
			Thread.sleep(5000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to reset old password using new password
	 * @param oldPassword - Old Password
	 * @param newPassword - New Password
	 */
	public void resetPassword(String oldPassword, String newPassword) {
		inputCurrPassword(oldPassword);
		inputNewPassword(newPassword);
		inputConfirmPassword(newPassword);
		clickUpdate();
		
	}
	protected void enterFirstName(String first) {
		firstName.type(first);
	}
	
	protected void enterLastName(String last) {
		lastName.type(last);
	}
	
	protected void enterAddress(String input) {
		address.type(input);
	}
	
	protected void enterCity(String cityName) {
		city.type(cityName);
	}
	
	protected void selectCountry(String country) {
		LOGGER.info("Selecting country: " + country);
		Select roledropdown = new Select(countrySelect);
		roledropdown.selectByVisibleText(country);
	}
	
	protected void enterApartment(String apartmentInfo) {
		apartment.type(apartmentInfo);
	}
	
	private String getPageLevelError() {
		String s = pageLevelError.getText();
		LOGGER.info("Getting the page level error as: "+s);
		return s;
	}
	
	protected void selectState(String state) {
		LOGGER.info("Selecting state: " + state);
		Select roledropdown = new Select(stateSelect);
		roledropdown.selectByVisibleText(state);
	}
	
	protected void enterZip(String zip) {
		zipCode.type(zip);
	}
	
	protected void enterPhone(String phoneNumber) {
		phone.type(phoneNumber);
	}
	
	private void clickEnterManual() {
		LOGGER.info("Clicking enter manual");
		enterAddressManual.click();
	}
	
	public void enterFieldsAndSubmit(String first, String last, String input, String apartmentInfo, String cityName, String country, String stateName, String zip, String phoneNumber) {
		enterFirstName(first);
		enterLastName(last);
		enterAddress(input);
		enterApartment(apartmentInfo);
		enterCity(cityName);
		selectCountry(country);
		selectState(stateName);
		enterZip(zip);
		enterPhone(phoneNumber);
		clickUpdate();
	}
	
	private String getFieldLevelError() {
		String s = fieldLevelError.getText();
		LOGGER.info("Getting the field level error as: "+s);
		return s;
	}
	
	public void enterAddressAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		if(enterAddressManual.exists()) {
			clickEnterManual();
		}
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectCountry(arr[5]);
		selectState(arr[6]);
		enterZip(arr[7]);
		enterPhone(arr[8]);
		clickUpdate();
	}
	
	public void enterAddressAndSubmitThreeTimes(String guestFields) {
		enterAddressAndSubmit(guestFields);
		sleep(2000);
		clickUpdate();
		sleep(2000);
		clickUpdate();
		sleep(1000);
	}
	
	
	public void verifyInformationUpdated() {
		sleep(2000);
		SA.assertThat(pageLevelMessage.getText()).isEqualToIgnoringCase("Personal Information has been updated successfully.");
		SA.assertAll();
	}
	
	public void verifyPageLevelError(String error) {
		assertThat(getPageLevelError()).as("Page Level Error").isEqualTo(error);
	}
	
	public void verifyFieldLevelError(String error) {
		assertThat(getFieldLevelError()).as("Field Level Error").isEqualTo(error);
	}
	
}