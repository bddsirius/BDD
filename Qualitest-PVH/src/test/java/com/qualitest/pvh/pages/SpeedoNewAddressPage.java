package com.qualitest.pvh.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoNewAddressPage extends NewAddressPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoNewAddressPage.class);
	
	@FindBy(xpath = "//*[@class = 'pvhOverlayContentWrapper']//*[@id= 'shopcartAddressForm']//*[@id = 'firstName']")
	protected BaseElement firstName;
	
	@FindBy(xpath = "//*[@id = 'shippingAddressList']//a[@class = 'link blue edit']")
	private List<WebElement> editShippingAddressList;
	
	@FindBy(xpath = "//*[@id = 'billingAddressList']//a[@class = 'link blue edit']")
	private List<WebElement> editBillingAddressList;
	
	@FindBy(xpath = "//*[@id = 'billingAddressList']//div[@class = 'addressColumn'][1]//a[@class='link blue edit']")
	private BaseElement editBillingListSecondOption;
	
	@FindBy(xpath = "//*[@id = 'shippingAddressList']//div[@class = 'addressColumn current'][1]//a[@class='link blue edit']")
	private BaseElement editShippingListFirstOption;
	
	@FindBy(xpath = "//*[@class = 'errorDisplayDiv pageLevelMessage nodisplay pageErrorMessage']")
	private BaseElement newAddressPageLevelError;
	
	public void clickFirstShippingAddressEdit() {
		LOGGER.info("Clicking the first edit button in the list of shipping addresses");
		editShippingAddressList.get(0).click();
	}
	public void clickFirstShippingAddressEditButton() {
		LOGGER.info("Clicking the first edit button in the list of shipping addresses");
		if(editShippingListFirstOption.exists()) {
			editShippingListFirstOption.click();
		}else {
			LOGGER.info("Could not find the edit shipping option");
		}
		
	}
	public void clickFirstBillingAddressEdit() {
		LOGGER.info("Clicking the first edit button in the list of billing addresses");
		editBillingAddressList.get(0).click();
	}
	
	private void clearFirstName() {
		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'pvhOverlayContentWrapper']//*[@id= 'shopcartAddressForm']//*[@id = 'firstName']")));
		LOGGER.info("Clearing the first name field");
		firstName.clear();
	}
	private void clearLastName() {
		LOGGER.info("Clearing the last name field");
		lastName.clear();
	}
	private void clearAddress() {
		LOGGER.info("Clearing the address field");
		address.clear();
	}
	private void clearApartment() {
		LOGGER.info("Clearing the apartment field");
		apartment.clear();
	}
	private void clearCity() {
		LOGGER.info("Clearing the city field");
		city.clear();
	}
	private void clearZip() {
		LOGGER.info("Clearing the zip field");
		zip.clear();
	}
	private void clearPhone() {
		LOGGER.info("Clearing the phone field");
		phoneNumber.clear();
	}
	private int getRandomNumber() {
		Random r = new Random();
		int low = 10;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		LOGGER.info("Getting a random number of: "+result);
		return result;
	}
	
	public void enterEditedAddress(String newAddress){
			
		String[] arr = newAddress.split(";");
		clearFirstName();
		enterFirstname(arr[1]);
		clearLastName();
		enterLastName(arr[2]);
		clickEnterManuallyEdit();
		clearAddress();
		String n = Integer.toString(getRandomNumber());
		Serenity.setSessionVariable("randomAddress").to(n);
		enterAddress(n+arr[3]);
		clearApartment();
		String r = Integer.toString(getRandomNumber());
		Serenity.setSessionVariable("randomApartment").to(r);
		enterApartment(r);
		clearCity();
		enterCity(arr[5]);
		selectState(arr[6]);
		clearZip();
		enterZip(arr[8]);
		clearPhone();
		enterPhone(arr[9]);
		clickAddShipToThisAddress();
		if(newAddressPageLevelError.exists()) {
			LOGGER.info("Found the Error on the page level");
			try
			{
			    Thread.sleep(5000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			clickAddShipToThisAddress(); 
			try
			{
			    Thread.sleep(5000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			clickAddShipToThisAddress(); 
		}
	}
	
	@Override
	public void clickSecondBillingAddressEdit() {
		LOGGER.info("Clicking the second edit button in the list of billing addresses");
		editBillingAddressList.get(1).click();
	}
	
	public void clickSecondBillingAddressEditButton() {
		LOGGER.info("Clicking the second edit button in the list of billing addresses");
		try
		{
		    Thread.sleep(5000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		editBillingListSecondOption.click();
	}
}
