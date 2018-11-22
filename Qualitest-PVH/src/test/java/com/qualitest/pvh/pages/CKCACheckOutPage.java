package com.qualitest.pvh.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CKCACheckOutPage extends BasePage{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CKCACheckOutPage.class);

	@FindBy(xpath = "//*[@id=\"Shipping\"]/div[1]/div[1]/div/input")
	private BaseElement firstName;
	
	@FindBy(xpath = "//*[@id=\"Shipping\"]/div[1]/div[2]/div/input")
	private BaseElement lastName;
	
	@FindBy(id = "ShippingAddresslookup")
	private BaseElement shippingAddress;
	
	@FindBy(xpath = "//*[@id= 'ShippingAddress.address1']")
	private BaseElement manualShippingAddress;
	
	@FindBy(id = "ShippingCountry")
	private BaseElement shippingCountry;
	
	@FindBy(id = "Shipping_phone")
	private BaseElement shippingPhone;
	
	@FindBy(xpath = "//*[@id=\"Shipping\"]/div[7]/div[2]/div[1]/div/div/div")
	private BaseElement phoneCountrySelector;
	
	@FindBy(xpath = "//*[@id=\"Shipping\"]/div[9]/input")
	private BaseElement emailInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[2]")
	private BaseElement firstRecommendedAddress;
	
	@FindBy(id = "chkGdprAgreement")
	private BaseElement agreement;
	
	@FindBy(id = "btnContinueToPayment")
	private BaseElement continueToPayment;
	
	@FindBy(xpath = "//*[@id = 'manualswitch']")
	private BaseElement manual;
	
	@FindBy(xpath = "//*[@id = 'postalcode']")
	private BaseElement postalCode;
	
	@FindBy(xpath = "//*[@id = 'ShippingAddress.city']")
	private BaseElement cityInput;
	
	@FindBy(xpath = "//*[@id = 'UseForBilling']")
	private BaseElement useForBilling;
	
	@FindBy(xpath = "//*[@name = 'BillingAddress.firstname']")
	private BaseElement billingFirstName;
	
	@FindBy(xpath = "//*[@name = 'BillingAddress.lastname']")
	private BaseElement billingLastName;
	
	@FindBy(xpath = "//*[@name = 'BillingAddress.address1']")
	private BaseElement billingAddress;
	
	@FindBy(xpath = "//*[@name = 'BillingAddress.postcode']")
	private BaseElement billingPostCode;
	
	@FindBy(xpath = "//*[@name = 'BillingAddress.city']")
	private BaseElement billingCity;
	
	@FindBy(xpath = "//*[@id = 'BillingCountry_value']")
	private BaseElement billingCountry;
	
	@FindBy(xpath = "//*[@id = 'Billing_phone']")
	private BaseElement billingPhone;
	
	@FindBy(xpath = "//*[@name = 'BillingAddress.email']")
	private  BaseElement billingEmail;
	
	@FindBy(id="paypalCheckout")
	private BaseElement paypalCheckout;
	
	private void enterBillingFirstName(String name) {
		LOGGER.info("Typing in "+ name+ " into first name field");
		billingFirstName.type(name);
	}
	private void enterBillingLastName(String name) {
		LOGGER.info("Typing in "+ name+ " into last name field");
		billingLastName.type(name);
	}
	private void enterBillingPhone(String number) {
		LOGGER.info("Typing in "+ number + " into phone field");
		try{
			billingPhone.sendKeys(number);
		}catch(Exception e) {
			new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'Billing_phone']")));
			billingPhone.sendKeys(number);
			LOGGER.info("Could not find the phone number field element");
		}
	}

	private void enterBillingEmail(String text) {
		LOGGER.info("Typing in "+ text + " into email field");
		billingEmail.type(text);
	}
	private void enterBillingPostalCode(String code) {
		LOGGER.info("Entering the postal code as: "+code);
		billingPostCode.type(code);
	}
	private void enterBillingCity(String city) {
		LOGGER.info("Entering the city as: "+city);
		billingCity.type(city);
	}
	private void enterBillingCountry(String country) {
		LOGGER.info("Entering the country as: "+country);
		billingCountry.type(country);
	}
	private void enterBillingAddress(String address) {
		LOGGER.info("Entering the address as: "+address);
		billingAddress.sendKeys(address);
	}
	
	private void enterFirstName(String name) {
		LOGGER.info("Typing in "+ name+ " into first name field");
		firstName.type(name);
	}
	private void enterLastName(String name) {
		LOGGER.info("Typing in "+ name+ " into last name field");
		lastName.type(name);
	}
	private void enterPhone(String number) {
		LOGGER.info("Typing in "+ number + " into phone field");
		shippingPhone.type(number);
	}
	private void enterEmail(String text) {
		LOGGER.info("Typing in "+ text + " into email field");
		emailInput.type(text);
	}
	private void clickAgreement() {
		LOGGER.info("CLicking agreement terms checkbox");
		agreement.click();
	}
	private void clickContinue() {
		LOGGER.info("Clicking continue to billing");
		continueToPayment.click();
	}
	private void clickManual() {
		LOGGER.info("Clicking manual input");
		manual.click();
	}
	private void enterPostalCode(String code) {
		LOGGER.info("Entering the postal code as: "+code);
		postalCode.type(code);
	}
	private void enterCity(String city) {
		LOGGER.info("Entering the city as: "+city);
		cityInput.type(city);
	}
	private void enterManualShippingAddress(String place) {
		LOGGER.info("Entering a manual shipping address of: "+place);
		manualShippingAddress.type(place);
	}
	private void clickUseForBilling() {
		LOGGER.info("Clicking use for billing button");
		useForBilling.click();
	}
	
	
	public void enterShippingInfo(String email, String firstName, String lastName, String address, String city, String zip, String phone ) {
		
		enterFirstName(firstName);
		enterLastName(lastName);
		clickManual();
		if(manual.exists()) {
			enterManualShippingAddress(address);
		}
		enterPostalCode(zip);
		enterCity(city);
		enterPhone(phone);
		enterEmail(email);
		clickAgreement();
		clickContinue();
		
	}
	
	public void enterShippingInfo(String newAddress ) {
		
		String[] arr = newAddress.split(";");
		enterFirstName(arr[1]);
		enterLastName(arr[2]);
		if(manual.exists()) {
			clickManual();
		}
		enterManualShippingAddress(arr[3]);
		enterPostalCode(arr[8]);
		enterCity(arr[5]);
		enterPhone(arr[9]);
		enterEmail(arr[0]);
		clickAgreement();
		clickContinue();
		
	}
	
	public void enterBillingInfo(String newBilling) {
		String[] arr = newBilling.split(";");
		clickUseForBilling();
		enterBillingFirstName(arr[1]);
		enterBillingLastName(arr[2]);
		enterBillingAddress(arr[3]);
		enterBillingPostalCode(arr[8]);
		enterBillingCity(arr[5]);
		enterBillingCountry(arr[7]);
		enterBillingPhone(arr[9]);
		enterBillingEmail(arr[0]);
	}
	
	public void navigateToPaypalCheckout() {
		LOGGER.info("Navigating to paypal checkout...");
		clickAgreement();
		paypalCheckout.click();
	}
	
	
}
