package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class ShippingPage extends BasePage {

	protected SoftAssertions SA = new SoftAssertions();
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(ShippingPage.class); 
	
	@FindBy(id = "guestEmailContinue" )
	private BaseElement continueAsGuest;
	
	@FindBy(id = "WC_ShoppingCartAddressEntryForm_emailr_1")
	private BaseElement emailInput;
	
	@FindBy(id = "firstName_shippingAddressCreateEditFormDiv_1")
	protected BaseElement firstNameInput;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_lastName_1")
	protected BaseElement lastNameInput;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_address1_1")
	private BaseElement addressInput;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_address2_1")
	private BaseElement apartmentInput;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_city_1" )
	private BaseElement cityInput;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_state_1")
	private BaseElement stateSelect;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_zipCode_1")
	private BaseElement zipInput;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_phone1_1")
	protected BaseElement phoneInput;
	
	@FindBy(id = "WC_ShoppingCartAddressEntryFormemailnewletter_default")
	private BaseElement newsLetter;
	
	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_country_1")
	private BaseElement countrySelect;
	
	@FindBy(id = "WC_UnregisteredCheckout_links_4")
	private BaseElement addressNext;
	
	@FindBy(xpath = "//a[contains(text(), 'Enter your address manually ')]")
	private List<WebElement> enterManual;
	
	@FindBy(id="continueGuest")
	private BaseElement continueGuest;
	
	@FindBy(xpath = "//*[@id= 'promoCode']")
	private BaseElement promoCodeInput;
	@FindBy(xpath = "//*[@id='pvhOverlayContentWrapper']/div[2]")
	private BaseElement popUp;
	
	@FindBy(xpath = "//*[@id= 'WC_PromotionCodeDisplay_links_1']")
	private BaseElement promoCodeButton;
	
	@FindBy(xpath = "//*[@class = 'discountsWrapper']/*[@class = 'discount clearfix orderItemDiscount']")
	private BaseElement promoDiscountDetails;
	
	@FindBy(xpath = "//*[@id = 'promotion_1']")
	private BaseElement removePromo;
	
	
	/**
	 * Method to close pop up displayed on order summary page
	 */
	protected void clickOffPopUp() {
		if(popUp.withTimeoutOf(5,TimeUnit.SECONDS).isVisible()) {
			LOGGER.info("Closing pop up displayed on order summary page");
			popUp.click();
		}
	}
	
	/**
	 * Method to enter provided value in email field 
	 * @param email - Email Address
	 */
	protected void enterEmail(String email) {
		LOGGER.info("Entering email address: " + email);
		emailInput.sendKeys(email);
	}
	
	/**
	 * Method to enter provided value in First Name field
	 * @param name - First Name
	 */
	protected void enterFirstName(String name) {
		LOGGER.info("Entering first name: " + name);
		firstNameInput.type(name);
	}
	
	/**
	 * Method to enter provided value in Last Name field
	 * @param name - Last Name
	 */
	protected void enterLastName(String name) {
		LOGGER.info("Entering last name: " + name);
		lastNameInput.type(name);
	}
	
	/**
	 * Method to enter provided value in address field
	 * @param address - Address Line 1
	 */
	protected void enterAddress(String address) {
		LOGGER.info("Entering address line1: "+ address);
		addressInput.type(address);
	}
	
	/**
	 * Method to enter provided value in apartment field
	 * @param apartment - Apartment
	 */
	protected void enterApartment(String apartment) {
		LOGGER.info("Entering apartment: " + apartment);
		apartmentInput.type(apartment);
	}
	
	/**
	 * Method to enter provided value in city field
	 * @param city - City
	 */
	protected void enterCity(String city) {
		LOGGER.info("Entering city: " + city);
		cityInput.type(city);
	}
	
	/**
	 * Method to select provided value in state dropdown
	 * @param state - State
	 */
	protected void selectState(String state) {
		LOGGER.info("Selecting state: " + state);
		Select roledropdown = new Select(stateSelect);
		roledropdown.selectByVisibleText(state);
	}
	
	/**
	 * Method to enter provided value in zip field
	 * @param zip - Zip Code
	 */
	protected void enterZip(String zip) {
		LOGGER.info("Entering zip code: " + zip);
		zipInput.type(zip);
	}
	
	/**
	 * Method to enter provided value in phone field
	 * @param phone - Phone Number
	 */
	protected void enterPhone(String phone) {
		LOGGER.info("Entering phone number: " + phone);
		phoneInput.type(phone);
	}
	
	/**
	 * Method to click the newsletter button to turn it off and on
	 */
	protected void clickNewsLetter() {
		if(newsLetter.exists()) {
			LOGGER.info("Clicking the newsletter button");
			newsLetter.click();
		}
	}
	
	protected void clickRemovePromo() {
		LOGGER.info("Removing promo code from check out");
		removePromo.click();
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method to select continue as guest option during checkout
	 */
	public void clickContinueAsGuest() {
		LOGGER.info("Clicking continue as guest button");
		continueAsGuest.click();
	}
	
	/**
	 * Method that clicks the promo code button
	 */
	private void clickPromoCodeButton() {
		LOGGER.info("Clicking the promo code button");
		promoCodeButton.click();
	}
	
	/**
	 * Enters the promo code into the promo code input field
	 * @param words
	 */
	private void enterPromoCode(String words) {
		LOGGER.info("Entering the promo code "+words);
		promoCodeInput.type(words);
	}
	
	
	/**
	 * Enters and submits the promo code into the promo code field
	 * @param words
	 */
	public void submitPromoCode(String words) {
		enterPromoCode(words);
		clickPromoCodeButton();
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isPromoCodeApplied() {
		boolean isThere =false;
		if(promoDiscountDetails.isVisible()) {
			isThere = true;
		}
		LOGGER.info("The promo code is applied: "+isThere);
		return isThere;
	}
	
	/**
	 * Method to click next button to continue onto Shipping method
	 */
	protected void clickAddressNext() {
		LOGGER.info("Clicking next button to go from address to shipping method");
		addressNext.click();
	}
	
	/**
	 * Method to click enter address manually option
	 */
	protected void clickEnterManual() {
		if(enterManual.size()>0) {
			LOGGER.info("Clicking enter manual address info");
			enterManual.get(0).click();
		} else {
			LOGGER.info("Enter manual address link is not displayed");
		}
	}

	/**
	 * Method to enter the attributes that are needed for address fields during checkout
	 * @param email - Email Address
	 * @param first - First Name
	 * @param last - Last Name
	 * @param address - Address Line 1
	 * @param apartment - Apartment #
	 * @param city - City
	 * @param state - State
	 * @param zip - Zip Code
	 * @param phone - Phone Number
	 */
	public void enterGuestFieldsAndSubmit(String email, String first, String last, String address, String apartment, String city, String state, String zip, String phone) {
		enterEmail(email);
		clickEnterManual();
		clickNewsLetter();
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
	
	/**
	 * Method to enter and submit address
	 * @param guestFields - Address Details email;first name;last name;address line 1;apartment;city;state;zip code;phone number
	 */
	public void enterAddressAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 10) {
			LOGGER.info("Incomplete address information provided");
		}
		enterEmail(arr[0]);
		try
		{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		if(continueGuest.exists()) {
			continueGuest.click();
		}
		sleep(3000);
		clickEnterManual();
		clickNewsLetter();
		clickOffPopUp();
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
		clickAddressNext();
	}
	
	public void verifyPromoCodeAppliedOnCheckout() {
		assertThat(isPromoCodeApplied()).as("Promo code is applied").isTrue();
	}
	
	public void verifyPromoCodeAppliedAndRemovedOnCheckout() {
		SA.assertThat(isPromoCodeApplied()).as("Promo code is applied").isTrue();
		clickRemovePromo();
		SA.assertThat(isPromoCodeApplied()).as("Promo code is not applied").isFalse();
		SA.assertAll();
	}
	
}
