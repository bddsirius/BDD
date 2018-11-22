package com.qualitest.pvh.pages;

public class CKShippingPage extends ShippingPage {

//	private static final Logger LOGGER = LoggerFactory.getLogger(CKCheckOutAddressPage.class); 
//	
//	@FindBy(id = "guestEmailContinue" )
//	private BaseElement continueAsGuest;
//	
//	@FindBy(id = "WC_ShoppingCartAddressEntryForm_emailr_1")
//	private BaseElement emailInput;
//	
//	@FindBy(id = "firstName_shippingAddressCreateEditFormDiv_1")
//	private BaseElement firstNameInput;
//	
//	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_lastName_1")
//	private BaseElement lastNameInput;
//	
//	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_address1_1")
//	private BaseElement addressInput;
//	
//	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_address2_1")
//	private BaseElement apartmentInput;
//	
//	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_city_1" )
//	private BaseElement cityInput;
//	
//	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_state_1")
//	private BaseElement stateSelect;
//	
//	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_zipCode_1")
//	private BaseElement zipInput;
//	
//	@FindBy(id = "WC__ShoppingCartAddressEntryForm_shippingAddressCreateEditFormDiv_1_phone1_1")
//	private BaseElement phoneInput;
//	
//	@FindBy(id = "WC_ShoppingCartAddressEntryFormemailnewletter_default")
//	private BaseElement newsLetter;
//	
//	@FindBy(id = "WC_UnregisteredCheckout_links_4")
//	private BaseElement addressNext;
//	
//	/**
//	 * Entering a String into the email field 
//	 * @param email
//	 */
//	public void enterEmail(String email) {
//		LOGGER.info("Entering into email: "+email);
//		emailInput.type(email);
//	}
//	/**
//	 * Entering a String into the First Name field
//	 * @param name
//	 */
//	public void enterFirstName(String name) {
//		LOGGER.info("Entering into first name: "+name);
//		firstNameInput.type(name);
//	}
//	/**
//	 * Entering a String into the Last Name field
//	 * @param name
//	 */
//	public void enterLastName(String name) {
//		LOGGER.info("Entering into last name: "+name);
//		lastNameInput.type(name);
//	}
//	/**
//	 * Entering a String into the address field
//	 * @param address
//	 */
//	public void enterAddress(String address) {
//		LOGGER.info("Entering into address: "+address );
//		addressInput.type(address);
//	}
//	public void enterApartment(String apartment) {
//		LOGGER.info("Entering apartment: "+apartment);
//		apartmentInput.type(apartment);
//	}
//	
//	/**
//	 * Entering a String into the city field
//	 * @param city
//	 */
//	public void enterCity(String city) {
//		LOGGER.info("Entering into city: "+city);
//		cityInput.type(city);
//	}
//	/**
//	 * Selecting a State in the state dropdown
//	 * @param state
//	 */
//	public void selectState(String state) {
//		LOGGER.info("Selecting state: " + state);
//		Select roledropdown = new Select(stateSelect);
//		roledropdown.selectByVisibleText(state);
//	}
//	/**
//	 * Entering a String into the zip field
//	 * @param zip
//	 */
//	public void enterZip(String zip) {
//		LOGGER.info("Entering into zip: "+zip);
//		zipInput.type(zip);
//	}
//	/**
//	 * Entering a phone number into the phone field
//	 * @param phone
//	 */
//	public void enterPhone(String phone) {
//		LOGGER.info("Entering into phone: "+phone);
//		phoneInput.type(phone);
//	}
//	/**
//	 * Clicking the newsletter button to turn it off and on
//	 */
//	public void clickNewsLetter() {
//		LOGGER.info("Clicking the newsletter button");
//		newsLetter.click();
//	}
//	/**
//	 * Clicking the continue as guest button
//	 */
//	public void clickContinueAsGuest() {
//		LOGGER.info("Clicking the continue as guest button");
//		continueAsGuest.click();
//	}
//	/**
//	 * Clicking the next button to continue onto Shipping method
//	 */
//	public void clickAddressNext() {
//		LOGGER.info("Clicking the next button to go from address to shipping method");
//		addressNext.click();
//	}
//	public void enterGuestFieldsAndSubmit(String email, String first, String last, String address, String apartment, String city, String state, String zip, String phone) {
//		enterEmail(email);
//		clickNewsLetter();
//		enterFirstName(first);
//		enterLastName(last);
//		if(!address.equals("")) {
//			enterAddress(address);
//		}
//		enterApartment(apartment);
//		enterCity(city);
//		selectState(state);
//		enterZip(zip);
//		enterPhone(phone);
//		clickAddressNext();
//	}
	
	
	
}
