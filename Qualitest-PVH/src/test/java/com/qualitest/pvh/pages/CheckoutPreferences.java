package com.qualitest.pvh.pages;

import org.openqa.selenium.support.ui.Select;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.assertj.core.api.SoftAssertions;

public class CheckoutPreferences extends BasePage {
	
	SoftAssertions SA = new SoftAssertions();
	
	@FindBy(id="WC_AjaxMyAccountQuickCheckoutProfileForm_links_7")
	private BaseElement update;

	@FindBy(id="WC_QuickCheckoutAddressForm_NameEntryForm_FormInput_shipping_firstName_1")
	private BaseElement firstName;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_NameEntryForm_FormInput_shipping_lastName_1")
	private BaseElement lastName;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_shipping_address1_1")
	private BaseElement address;

	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_shipping_address2_1")
	private BaseElement apartment;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_shipping_city_1")
	private BaseElement city;
	
	@FindBy(id="shipping_country")
	private BaseElement countrySelect;
	
	@FindBy(id="shipping_WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_shipping_state_1")
	protected BaseElement stateSelect;

	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_shipping_zipCode_1")
	private BaseElement zipCode;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_shipping_phone1_1")
	private BaseElement phone;
	
	@FindBy(id="pageLevelMessage")
	private BaseElement pageLevelMessage;
	
	@FindBy(id = "SameShippingAndBillingAddress")
	private BaseElement SameAsShipCheckBox;
	
	@FindBy(xpath = "//*[@id='shipAddr']/div[4]/div[2]/a")
	private BaseElement enterAddrMan;
	
	@FindBy(xpath = "//*[@id=\"billAddr\"]/div[4]/div[2]/a")
	private BaseElement enterBillingAddrMan;
	
	@FindBy(id="countryText")
	private BaseElement CardType;
	
	@FindBy(id="pay_temp_account")
	private BaseElement CardNumber;
	
	@FindBy(id="pay_expire_month")
	private BaseElement ExpMonth;
	
	@FindBy(id="pay_expire_year")
	private BaseElement ExpYear;
	
	@FindBy(xpath ="//*[@id='fieldErrorMessage']")
	private BaseElement errorMessage;

	
	@FindBy(id="WC_QuickCheckoutAddressForm_NameEntryForm_FormInput_billing_firstName_1")
	private BaseElement billingFirstName;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_NameEntryForm_FormInput_billing_lastName_1")
	private BaseElement billingLastName;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_billing_address1_1")
	private BaseElement billingAddr;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_billing_address2_1")
	private BaseElement billingApartSuite;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_billing_city_1")
	private BaseElement billingCity;
	
	@FindBy(id="billing_country")
	private BaseElement billingCountrySelect;
	
	@FindBy(id="billing_WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_billing_state_1")
	private BaseElement billingStateSelect;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_billing_zipCode_1")
	private BaseElement billingZipCode;
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_billing_phone1_1")
	private BaseElement billingPhoneNumber;
	
	public void clickOffSameAsBilling()
	{
		SameAsShipCheckBox.click();
	}
	
	protected void enterFirstName(String first) {
		firstName.type(first);
	}
	
	protected void enterBillingFirstName(String first) {
		billingFirstName.type(first);
	}
	
	protected void enterLastName(String last) {
		lastName.type(last);
	}
	protected void enterBillingLastName(String last) {
		billingLastName.type(last);
	}
	
	protected void enterAddress(String input) {
		address.type(input);
	}
	protected void enterBillingAddress(String input) {
		billingAddr.type(input);
	}
	
	protected void enterCity(String cityName) {
		city.type(cityName);
	}
	
	protected void enterBillingCity(String cityName) {
		billingCity.type(cityName);
	}
	
	protected boolean checkForCreditCardInfo()
	{
		sleep(1000);
		try {
			CardNumber.type("134");
		} catch (Exception e) {
			return false;
		}
		sleep(1000);
		return true;
		
	}
	
	
	protected void checkForEnterAddrMan()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			enterAddrMan.click();

		} catch (Exception e) {

		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	protected void checkForEnterBillingAddrMan()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			enterBillingAddrMan.click();

		} catch (Exception e) {

		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void selectCountry(String country) {
		LOGGER.info("Selecting country: " + country);
		Select roledropdown = new Select(countrySelect);
		roledropdown.selectByVisibleText(country);
	}
	
	protected void selectBillingCountry(String country) {
		LOGGER.info("Selecting country: " + country);
		Select roledropdown = new Select(billingCountrySelect);
		roledropdown.selectByVisibleText(country);
	}
	
	protected void enterApartment(String apartmentInfo) {
		apartment.type(apartmentInfo);
	}
	
	protected void enterBillingApartment(String apartmentInfo) {
		billingApartSuite.type(apartmentInfo);
	}
	
	protected void selectState(String state) {
		LOGGER.info("Selecting state: " + state);
		Select roledropdown = new Select(stateSelect);
		roledropdown.selectByVisibleText(state);
	}
	
	protected void selectBillingState(String state) {
		LOGGER.info("Selecting state: " + state);
		Select roledropdown = new Select(billingStateSelect);
		roledropdown.selectByVisibleText(state);
	}
	
	protected void enterZip(String zip) {
		zipCode.type(zip);
	}
	
	protected void enterBillingZip(String zip) {
		billingZipCode.type(zip);
	}
	
	protected void enterPhone(String phoneNumber) {
		phone.type(phoneNumber);
	}
	
	protected void enterBillingPhone(String phoneNumber) {
		billingPhoneNumber.type(phoneNumber);
	}
	
	protected void enterCreditCard(String cardNum) {
		CardNumber.type(cardNum);
	}
	
	protected void selectExpMonth(String month) {
		LOGGER.info("Selecting country: " + month);
		Select roledropdown = new Select(ExpMonth);
		roledropdown.selectByVisibleText(month);
	}
	
	
	protected void selectExpYear(String year) {
		LOGGER.info("Selecting country: " + year);
		Select roledropdown = new Select(ExpYear);
		roledropdown.selectByVisibleText(year);
	}
	protected void clickUpdate() {
		LOGGER.info("Clicking update button");
		update.click();
		try {
			Thread.sleep(5000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editCheckoutInformation(String guestFields) {
		// TODO Auto-generated method stub
		checkForEnterAddrMan();
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
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
		if(checkForCreditCardInfo())
		{
			enterCreditCard(arr[9]);
			selectExpMonth(arr[10]);
			selectExpYear(arr[11]);
		}
		clickUpdate();
	}
	
	public void editBillingCheckoutInformation(String guestFields) {
		// TODO Auto-generated method stub
		checkForEnterBillingAddrMan();
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterBillingFirstName(arr[0]);
		enterBillingLastName(arr[1]);
		if(!arr[2].equals(" ")) {
			enterBillingAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterBillingApartment(arr[3]);
		}
		enterBillingCity(arr[4]);
		selectBillingCountry(arr[5]);
		selectBillingState(arr[6]);
		enterBillingZip(arr[7]);
		enterBillingPhone(arr[8]);
		if(checkForCreditCardInfo())
		{
			enterCreditCard(arr[9]);
			selectExpMonth(arr[10]);
			selectExpYear(arr[11]);
		}
		clickUpdate();
	}
	
	
	public void verifyInformationUpdated() {
		SA.assertThat(getDriver().getTitle().contains("Account Summary"));
		SA.assertAll();
	}
	public void verifyErrorMessage() {
		
		if(errorMessage.isCurrentlyVisible())
		{
			SA.assertThat(errorMessage.getText().contains("cannot be empty") || errorMessage.getText().contains("valid format"));
			
		}
		else
		{
			SA.assertThat(pageLevelMessage.getText().contains("error"));
		}
		SA.assertAll();
	}
	
public void verifyCardErrorMessage() {
		

		SA.assertThat(pageLevelMessage.getText().toLowerCase().contains("card number is invalid"));

		SA.assertAll();
	}


public void verifyEmptyErrorMessage() {
	

	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(errorMessage.isVisible())
	{
		SA.assertThat(errorMessage.getText().toLowerCase().contains("cannot be empty"));
	}
	else
	{
		SA.assertThat(pageLevelMessage.getText().toLowerCase().contains("cannot be empty"));
	}


	SA.assertAll();
}
}
