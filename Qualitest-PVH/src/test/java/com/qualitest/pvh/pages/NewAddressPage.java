package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class NewAddressPage extends BasePage{

	@FindBy(xpath = "//*[@id = 'shippingAddressList']/div[2]/h2/a")
	private BaseElement addNewAddress;
	
	@FindBy(xpath = "//*[@id = 'billingAddressList']/div[2]/h2/a") 
	private BaseElement addNewBillingAddress; 
	 
	@FindBy(xpath = "//*[@id= 'createOrEditAddress']//input[@id = 'firstName']")
	protected BaseElement firstName;
	
	@FindBy(xpath = "//*[@id = 'lastName']")
	protected BaseElement lastName;
	
	@FindBy(xpath = "//a[contains( text(), 'Enter your address manually')]")
	protected BaseElement enterManuallyEdit;
	
	@FindBy(xpath = "//*[@id='centered_single_column_form']/div[1]/div[2]/div[4]/div[2]/a") 
	protected BaseElement enterManually;
	
	@FindBy(id = "address1")
	protected BaseElement address;
	
	@FindBy(id = "address2")
	protected BaseElement apartment;
	
	@FindBy(id = "city")
	protected BaseElement city;
	
	@FindBy(id = "state")
	private BaseElement state;
	
	@FindBy(id = "zipCode")
	protected BaseElement zip;
	
	@FindBy(id = "phone1")
	protected BaseElement phoneNumber;
	
	@FindBy(id = "email1")
	protected BaseElement email;
	
	@FindBy(id = "addToBothShippingBilling")
	protected BaseElement useForBilling;
	
	@FindBy(xpath = "//*[@id = 'SaveShopCartAddressButtonWrapper']/a[1]") 
	private BaseElement addAndShipToThisAddress;
	
	@FindBy(xpath = "//*[@class = 'addressColumn current']/div/div[1]")
	private BaseElement currentAddressChosen;
	
	@FindBy(xpath = "//*[contains( text(), 'SHIP TO THIS ADDRESS')]") 
	private List<WebElement> shipToThisAddressList; 
	 
	@FindBy(xpath = "//*[contains( text(), 'USE THIS ADDRESS')]") 
	private List<WebElement> useThisBillingAddressList; 
	 
	@FindBy(xpath = "//*[@id = 'shippingAddressList']/div/div[2]/div[1]/div[1]") 
	private BaseElement secondAddressOptionText; 
	 
	@FindBy(xpath = "//*[@id = 'billingAddressList']/div/div[2]/div[1]/div[1]") 
	private BaseElement secondBillingAddressOptionText; 
	 
	@FindBy(xpath = "//*[@id = 'shippingAddressList']//a[contains( text(), 'EDIT')]")
	private List<WebElement> editShippingAddressList;
	
	@FindBy(xpath = "//*[@id = 'billingAddressList']//a[contains( text(), 'EDIT')]")
	private List<WebElement> editBillingAddressList;
	
	@FindBy(xpath = "//*[@id ='billingAddressList']/div[1]/div")
	private List<WebElement> listOfBillingAddresses;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewAddressPage.class);

	public void clickNewBillingAddress() { 
		LOGGER.info("Clicking add new billing address"); 
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		addNewBillingAddress.click(); 
	} 
	 
	
	/**
	 * Clicking add new address button
	 */
	public void clickNewAddress() {
		LOGGER.info("Clicking add new address");
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		addNewAddress.click();
	}
	
	/**
	 * Entering first name in the new address feature
	 * @param name
	 */
	protected void enterFirstname(String name) {
		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'pvhOverlayContentWrapper']//*[@id= 'shopcartAddressForm']//*[@id = 'firstName']")));
		LOGGER.info("Entering new first name as: "+name);
		firstName.type(name);
	}
	
	/**
	 * Entering last name in the new address feature
	 * @param name
	 */
	protected void enterLastName(String name) {
		LOGGER.info("Entering new last name as: "+name);
		lastName.type(name);
	}
	
	/**
	 * Entering new address in the new address feature
	 * @param add
	 */
	protected void enterAddress(String add) {
		LOGGER.info("Entering new address as: "+add);
		address.type(add);
	}
	
	/**
	 * Entering the new apartment number in the new address feature
	 * @param apartment
	 */
	protected void enterApartment(String apart) {
		LOGGER.info("Entering new apartment as: "+apart);
		apartment.type(apart);
	}
	
	/**
	 * Entering the new city in the new address feature
	 * @param city
	 */
	protected void enterCity(String ci) {
		LOGGER.info("Entering new city as: "+ci);
		city.type(ci);
	}
	
	/**
	 * Entering the new state in the new feature feature
	 * @param state
	 */
	protected void selectState(String sta) {
		LOGGER.info("Selecting new state as: "+sta);
		Select roledropdown = new Select(state);
		roledropdown.selectByVisibleText(sta);
	}
	
	/**
	 * Entering a new zip code in the new address feature
	 * @param code
	 */
	protected void enterZip(String code) {
		LOGGER.info("Entering new zip code as: "+code);
		zip.type(code);
	}
	
	/**
	 * Enter a new phone number in the new address feature
	 * @param number
	 */
	protected void enterPhone(String number) {
		LOGGER.info("Entering new phone number as: "+number);
		phoneNumber.type(number);
	}
	
	/**
	 * Entering a new email in the new address feature
	 * @param mail
	 */
	protected void enterEmail(String mail) {
		LOGGER.info("Entering new email as: "+mail);
		email.type(mail);
	}
	
	/**
	 * Clicking the use this new address for shipping as well button 
	 */
	protected void clickUseForShippingBilling() {
		LOGGER.info("Clicking to use for shipping and billing");
		useForBilling.click();
	}
	
	/**
	 * Clicking the add the address and confirm it as the new address
	 */
	protected void clickAddShipToThisAddress() {
		LOGGER.info("Clicking add and ship to this address");
		if(addAndShipToThisAddress.exists()) { 
			addAndShipToThisAddress.click();
		}else { 
			LOGGER.info("Couldn't find the add shipping address"); 
		} 		
	}
	
	/**
	 * This clicks the manual button under the add an address feature. It first checks to see if exists then it acts or doesn't
	 */
	protected void clickEnterManually() {
		if(enterManually.exists()) {
			LOGGER.info("Clicking enter manually");
			enterManually.click();
		}else {
			LOGGER.info("Couldn't find a manual address button, so automation will skip this action and add fields");
		}
		
	}
	
	/**
	 * This clicks the manual button under the edit address feature. It first checks to see if exists then it acts or doesn't
	 */
	protected void clickEnterManuallyEdit() {
		if(enterManuallyEdit.exists()) {
			LOGGER.info("Clicking enter manually");
			enterManuallyEdit.click();
		}else {
			LOGGER.info("Couldn't find a manual address button, so automation will skip this action and add fields");
		}
		
	}
	
	/**
	 * Getting the address that is currently selected
	 * @return A string of the address
	 */
	protected String getCurrentAddress() {
		String text = currentAddressChosen.getText();
		LOGGER.info("Getting the current address that is selected as: "+text);
		return text;
	}
	
	/**
	 * The put all together function that takes the functions from above and compresses it to this
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param apartment
	 * @param city
	 * @param state
	 * @param zip
	 * @param phoneNumber
	 * @param email
	 */
	public void enterNewAddress(String newAddress){

		String[] arr = newAddress.split(";");
		enterFirstname(arr[1]);
		enterLastName(arr[2]);
		clickEnterManually();
		enterAddress(arr[3]);
		enterApartment(arr[4]);
		enterCity(arr[5]);
		selectState(arr[6]);
		enterZip(arr[8]);
		enterPhone(arr[9]);
		enterEmail(arr[0]);
		clickUseForShippingBilling();
		sleep(3000);
		clickAddShipToThisAddress();
	}
	
	/**
	 * Takes a string of all the parameter and divides it up to create a new billing address. 
	 * Side note: It only work if the user is not signed in
	 * @param newAddress
	 */
	public void enterNewBillingAddress(String newAddress){

		String[] arr = newAddress.split(";");
		enterFirstname(arr[1]);
		enterLastName(arr[2]);
		clickEnterManually();
		enterAddress(arr[3]);
		enterApartment(arr[4]);
		enterCity(arr[5]);
		selectState(arr[6]);
		enterZip(arr[8]);
		enterPhone(arr[9]);
		enterEmail(arr[0]);
		clickAddShipToThisAddress();
	}
	
	/**
	 * Gets a modded second sahipping address in the list of different shipping addresses
	 * @return
	 */
	public String getModdedSecondShippingAddress() { 
		String text = getSecondAddressText(); 
		text = text.replace("\n", " ").replace("\r", " "); 
		text = text.replace("NJ", "New Jersey"); 
		LOGGER.info("Getting modded string as: "+text); 
		return text; 
	} 
	 
	/**
	 * Removes all the white spaces in the modded string
	 * @return
	 */
	public String getModdedRemoveAllSpacesAddress() { 
		String text = getModdedSecondShippingAddress(); 
		text = text.replaceAll("\\s+",""); 
		LOGGER.info("Returning a no space String of: "+text); 
		return text; 
	} 
	 
	/**
	 * Get a number of addresses in the shipping addresses
	 * @return
	 */
	protected int getNumberOfAddress() { 
		int num = shipToThisAddressList.size(); 
		LOGGER.info("Getting the size of the address list as: "+num); 
		return num; 
	} 
	 
	/**
	 * Getting a number of addresses in the billing list of shipping addresses
	 * @return
	 */
	public int getNumberOfBillingAddresses() { 
		int num = useThisBillingAddressList.size(); 
		LOGGER.info("Getting the size of the billing address list as: "+num); 
		return num; 
	} 
	 
	/**
	 * Getting a modded second billing shipping address
	 * @return
	 */
	public String getModdedBillingAddressMatchingName(String firstName, String lastName) { 
		
		String text = "";
		for(WebElement w : listOfBillingAddresses) {
			String t = w.findElement(By.xpath(".//*[@class = 'address']")).getText();
			if(t.contains(firstName) && t.contains(lastName)) {
				text = t;
				LOGGER.info("Setting the text in the billing addresses as: "+t);
				break;
			}
		}
		text = text.replace("\n", " ").replace("\r", " "); 
		text = text.replace("NJ", "New Jersey"); 
		text = text.replaceAll("\\s+","");
		LOGGER.info("Getting modded string as: "+text); 
		return text; 
	} 
	 
	/**
	 * Gets a second address text
	 * @return
	 */
	public String getSecondAddressText() { 
		String text = secondAddressOptionText.getText(); 
		LOGGER.info("Getting the second address option as: "+text); 
		return text; 
	} 
	
	/**
	 * Gets the second billing address
	 * @return
	 */
	public String getSecondBillingAddressText() { 
		String text = secondBillingAddressOptionText.getText(); 
		LOGGER.info("Getting the second address option as: "+text); 
		return text; 
	} 
	 
	/**
	 * Clicking a second address
	 */
	public void clickSecondAddress() { 
		try { 
			LOGGER.info("Clicking the second address, which isn't the current"); 
			shipToThisAddressList.get(1).click(); 
		}catch(Exception e) { 
			LOGGER.info("Cannot find a second address to click"); 
		} 
	} 
	 
	 
	/**
	 * Clicking the second billing address
	 */
	public void clickSecondBillingAddress() { 
		try { 
			LOGGER.info("Clicking the second address, which isn't the current"); 
			useThisBillingAddressList.get(1).click(); 
		}catch(Exception e) { 
			LOGGER.info("Cannot find a second address to click"); 
		} 
	}
	
	public void clickBillingAddressByFirstName(String firstName, String lastName) {
		try { 
			for(WebElement w : listOfBillingAddresses) {
				String text = w.findElement(By.xpath(".//*[@class = 'address']")).getText();
				if(text.contains(firstName) && text.contains(lastName)) {
					w.findElement(By.xpath(".//*[contains( text(), 'USE THIS ADDRESS')]")).click();
					break;
				}
			}
		}catch(Exception e) { 
			LOGGER.info("Cannot find a second address to click"); 
		} 
	}
	
	/**
	 * Clicks the first shipping address edit
	 */
	public void clickFirstShippingAddressEdit() {
		LOGGER.info("Clicking the first edit button in the list of shipping addresses");
		editShippingAddressList.get(0).click();
	}
	
	/**
	 * Clicks the first Billing address edit
	 */
	public void clickFirstBillingAddressEdit() {
		LOGGER.info("Clicking the first edit button in the list of billing addresses");
		editBillingAddressList.get(0).click();
		
	}
	
	/**
	 * Clicks the second billing address edit
	 */
	public void clickSecondBillingAddressEdit() {
		LOGGER.info("Clicking the second edit button in the list of billing addresses");
		editBillingAddressList.get(1).click();
	}
	
	/**
	 * Enter new address while signed in. It's slightly different from the other enter address function, but there is no email input.
	 * Since you are signed in. The email is already taken care of
	 * @param newAddress
	 */
	public void signedInEnterBillingAddress(String newAddress) {
		String[] arr = newAddress.split(";");
		enterFirstname(arr[1]);
		enterLastName(arr[2]);
		clickEnterManually();
		enterAddress(arr[3]);
		enterApartment(arr[4]);
		enterCity(arr[5]);
		selectState(arr[6]);
		enterZip(arr[8]);
		enterPhone(arr[9]);
		clickAddShipToThisAddress();
	}
}
