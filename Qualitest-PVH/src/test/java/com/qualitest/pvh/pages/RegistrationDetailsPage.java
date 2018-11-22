package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class RegistrationDetailsPage extends BasePage {
	
	@FindBy(id = "WC_UserRegistrationAddForm_NameEntryForm_FormInput_firstName_1")
	private BaseElement firstNameInput;

	@FindBy(id = "WC_UserRegistrationAddForm_NameEntryForm_FormInput_lastName_1")
	private BaseElement lastNameInput;

	@FindBy(id = "WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address1_1")
	private BaseElement addressInput;

	@FindBy(id = "WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address2_1")
	private BaseElement apartmentInput;

	@FindBy(id = "WC_UserRegistrationAddForm_AddressEntryForm_FormInput_city_1")
	private BaseElement cityInput;

	@FindBy(id = "WC_UserRegistrationAddForm_AddressEntryForm_FormInput_country_1")
	private BaseElement countryDropDown;

	@FindBy(id = "WC_UserRegistrationAddForm_AddressEntryForm_FormInput_state_1")
	private BaseElement stateDropDown;

	@FindBy(id = "WC_UserRegistrationAddForm_AddressEntryForm_FormInput_zipCode_1")
	private BaseElement zipInput;

	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1")
	private BaseElement phoneInput;

	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_gender_In_Register_1")
	private BaseElement genderDropDown;

	@FindBy(id = "WC_PersonalInfoExtension_birth_month")
	private BaseElement monthDropDown;

	@FindBy(id = "WC_PersonalInfoExtension_birth_date")
	private BaseElement dayDropDown;

	@FindBy(css = "div.addressColumns.clearfix > #userRegistrationSaveWrapper > #WC_UserRegistrationAddForm_links_1")
	private BaseElement submit;
	
	@FindBy(xpath = "//*[@id=\"WC_MyAccountCenterLinkDisplay_div_6\"]/div[1]")
	private BaseElement welcomeTitle;

	@FindBy(css = "div.pvhOverlayCloseX")
	private BaseElement popUpClose;
	
	@FindBy(id="WC_UserRegistrationAddForm_links_2")
	public BaseElement goToAccountSummaryPage;
	
	@FindBy(id="my_account_link")
	public BaseElement myAccount;
	
	@FindBy(xpath = "//a[contains(text(), 'Enter your address manually ')]")
	private List<WebElement> enterManual;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationDetailsPage.class);

	
	public void goToAccountSummaryPage(){
		LOGGER.info("Going to account summary page...");
		waitFor(3000);
		if(goToAccountSummaryPage.exists()) {
				goToAccountSummaryPage.click();
		}else {
			myAccount.click();
			}
		}
		
	
	/**
	 * Method to enter value in the first name field
	 * 
	 * @param name - First Name
	 */
	public void enterFirstName(String name) {
		LOGGER.info("Entering first name: " + name);
		firstNameInput.type(name);
	}

	/**
	 * Method to enter value in the last name field
	 * 
	 * @param name - Last Name
	 */
	public void enterLastName(String name) {
		LOGGER.info("Entering last name: " + name);
		lastNameInput.type(name);
	}

	/**
	 * Method to enter value in the apartment field
	 * 
	 * @param apart - Apartment
	 */
	public void enterApartment(String apart) {
		LOGGER.info("Entering apartment number: " + apart);
		apartmentInput.type(apart);
	}

	/**
	 * Method to enter value in the address field
	 * 
	 * @param address - Address
	 */
	public void enterAddress(String address) {
		LOGGER.info("Entering address: " + address);
		addressInput.type(address);
	}

	/**
	 * Method to enter value in the city field
	 * 
	 * @param city - City
	 */
	public void enterCity(String city) {
		LOGGER.info("Entering city: " + city);
		cityInput.type(city);
	}

	/**
	 * Method to select value in the country drop down field
	 * 
	 * @param country - Country. Value is case sensitive e.g.: United States ,
	 *                Canada
	 */
	public void selectCountry(String country) {
		LOGGER.info("Selecting country: " + country);
		Select roledropdown = new Select(countryDropDown);
		roledropdown.selectByVisibleText(country);
	}

	/**
	 * Method to select value in state drop down field
	 * 
	 * @param state - State. Value is case sensitive e.g.: New Jersey , New York
	 */
	public void selectState(String state) {
		LOGGER.info("Selecting state: " + state);
		Select roledropdown = new Select(stateDropDown);
		roledropdown.selectByVisibleText(state);
	}

	/**
	 * Method to enter value in zip code field
	 * 
	 * @param zip - Zip Code
	 */
	public void enterZip(String zip) {
		LOGGER.info("Entering zip: " + zip);
		zipInput.type(zip);
	}

	/**
	 * Method to enter value in phone number field
	 * 
	 * @param phone - Phone Number
	 */
	public void enterPhone(String phone) {
		LOGGER.info("Entering phone: " + phone);
		phoneInput.type(phone);
	}

	/**
	 * Method to select value in gender drop down field
	 * 
	 * @param gender - Gender. Possible value are Male , Female
	 */
	public void selectGender(String gender) {
		Select roledropdown = new Select(genderDropDown);
		if (!gender.isEmpty()) {
			LOGGER.info("Selecting gender: " + gender);
			roledropdown.selectByVisibleText(gender);
		} else {
			LOGGER.info("Skipping Gender field value selection");
		}
	}

	/**
	 * Method to enter value in dob month field
	 * 
	 * @param month - DOB Month. Value should be a string e.g. January , February
	 */
	public void selectBirthdayMonth(String month) {
		Select roledropdown = new Select(monthDropDown);
		if (!month.isEmpty()) {
			LOGGER.info("Entering Birthday month: " + month);
			roledropdown.selectByVisibleText(month);
		} else {
			LOGGER.info("Skipping Birthday month field value selection");
		}
	}

	/**
	 * Method to enter value in dob day field
	 * 
	 * @param day - DOB Day. Value should be between 1 to 31
	 */
	public void selectBirthdayDay(String day) {
		Select roledropdown = new Select(dayDropDown);
		if (!day.isEmpty()) {
			LOGGER.info("Entering Birthday day: " + day);
			roledropdown.selectByVisibleText(day);
		} else {
			LOGGER.info("Skipping Birthday day field value selection");
		}
	}

	/**
	 * Method to click Save button
	 */
	public void clickSave() {
		LOGGER.info("Clicking save/submit button");
		submit.click();
	}
	
	protected void clickEnterManual() {
		if(enterManual.size()>0) {
			LOGGER.info("Clicking enter manual address info");
			enterManual.get(0).click();
		} else {
			LOGGER.info("Enter manual address link is not displayed");
		}
	}
	
	/**
	 * Method to enter registration detail on calvin klein web site
	 * 
	 * @param firstName - First Name
	 * @param lastName  - Last Name
	 * @param address   - Address Line 1
	 * @param apartment - Apartment Number
	 * @param city      - City
	 * @param country   - Country. Value is case sensitive e.g.: United States ,
	 *                  Canada
	 * @param state     - State. Value is case sensitive e.g.: New Jersey , New York
	 * @param zip       - Zip Code
	 * @param phone     - Phone Number
	 * @param gender    - Gender. Possible value are Male , Female
	 * @param bMonth    - DOB Month. Value should be a string e.g. January ,
	 *                  February
	 * @param bDay      - DOB Day. Value should be between 1 to 31
	 */
	public void fillOutRegistration(String firstName, String lastName, String address, String apartment, String city,
			String country, String state, String zip, String phone, String gender, String bMonth, String bDay) {
		enterFirstName(firstName);
		enterLastName(lastName);
		clickEnterManual();
		enterApartment(apartment);
		enterAddress(address);
		enterCity(city);
		selectCountry(country);
		selectState(state);
		enterZip(zip);
		enterPhone(phone);
		selectGender(gender);
		selectBirthdayMonth(bMonth);
		selectBirthdayDay(bDay);
		clickSave();
	}

	
	/**
	 * Method to read
	 * 
	 * @return
	 */
	public String getWelcome() {
		return welcomeTitle.getText();
	}

	/**
	 * Method to close pop up
	 */
	public void clickPopUpClose() {
		LOGGER.info("Clicking the close popup function ");
		try {
			popUpClose.click();
		} catch (Exception e) {
			LOGGER.info("Pop up not displayed, skipping closing pop up step.");
		}
	}

	/**
	 * Method to verify specified error message is displayed or not
	 * @param error - Error Message
	 */
	public void verifyError(String error) {
		assertThat(verifyErrorExists(error)).as("Error message on Registration Details Page").isTrue();
	}
	
	public abstract void verifyPageTitle();

}