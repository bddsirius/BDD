package com.qualitest.pvh.pages;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import com.qualitest.pvh.teststeps.CheckoutTestSteps;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CKCAOrderSummaryPage extends BasePage{
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(CheckoutTestSteps.class);

	
	@FindBy(xpath = "//*[@id=\"orderCancelMessage\"]/a")
	private BaseElement cancelOrder;

	@FindBy(xpath = "//*[@id=\"shoppingBagColumn2\"]/div[4]")
	private BaseElement cancellationField;
	
	@FindBy(xpath = "//*[@id='orderCancelSection']/div/a[1]")
	private BaseElement agreeToCancel;
	
	@FindBy(xpath = "//*[@class = 'col-xs-8 col-sm-8 col-md-8 col-lg-8 ng-binding']")
	private List<WebElement> listOfAddresses;
	
	private SoftAssertions SA = new SoftAssertions();
	

	private String getShippingFullName() {
		String s = listOfAddresses.get(0).getText();
		LOGGER.info("Getting the full name of the shipping address: " +s);
		return s;
	}
	
	private String getShippingAddress() {
		String s = listOfAddresses.get(1).getText();
		LOGGER.info("Getting the shipping address as: "+s);
		return s;
	}
	
	private String getShippingEmail() {
		String s = listOfAddresses.get(2).getText();
		LOGGER.info("Getting the shipping address as: "+s);
		return s;
	}
	
	private String getShippingPhone() {
		String s = listOfAddresses.get(3).getText();
		LOGGER.info("Getting the shipping email: "+s);
		return s;
	}
	
	private String getBillingFullName() {
		String s = listOfAddresses.get(4).getText();
		LOGGER.info("Getting the full name of the billing address: " +s);
		return s;
	}
	
	private String getBillingAddress() {
		String s = listOfAddresses.get(5).getText();
		LOGGER.info("Getting the billing address as: "+s);
		return s;
	}
	
	private String getBillingEmail() {
		String s = listOfAddresses.get(6).getText();
		LOGGER.info("Getting the billing address as: "+s);
		return s;
	}
	
	private String getBillingPhone() {
		String s = listOfAddresses.get(7).getText();
		LOGGER.info("Getting the billing email: "+s);
		return s;
	}
	
	public void verifyShippingAddress(String address) {
		String[] arr = address.split(";");
		String fullName = getShippingFullName();
		SA.assertThat(fullName).contains(arr[1]);
		SA.assertThat(fullName).contains(arr[2]);
		String add = getShippingAddress();
		SA.assertThat(add).contains(arr[3]);
		//SA.assertThat(add).contains(arr[4]);
		SA.assertThat(add).contains(arr[5]);
		SA.assertThat(add).contains(arr[6]);
		SA.assertThat(add).contains(arr[8]);
		String email = getShippingEmail();
		SA.assertThat(email).contains(arr[0]);
		String phone = getShippingPhone();
		SA.assertThat(phone).contains(arr[9]);
		SA.assertAll();
		
	}
	
	public void verifyBillingAddress(String address) {
		String[] arr = address.split(";");
		String fullName = getBillingFullName();
		SA.assertThat(fullName).contains(arr[1]);
		SA.assertThat(fullName).contains(arr[2]);
		String add = getBillingAddress();
		SA.assertThat(add).contains(arr[3]);
		//SA.assertThat(add).contains(arr[4]);
		SA.assertThat(add).contains(arr[5]);
		SA.assertThat(add).contains(arr[6]);
		SA.assertThat(add).contains(arr[8]);
		String email = getBillingEmail();
		SA.assertThat(email).contains(arr[0]);
		String phone = getBillingPhone();
		SA.assertThat(phone).contains(arr[9]);
		SA.assertAll();
	}
	
	


	public void verifyCancellation()
	{
		cancelOrder.click();
		agreeToCancel.click();
		SA.assertThat(cancellationField.getText().toUpperCase().contains("THE ORDER HAS BEEN CANCELED SUCCESSFULLY")).isTrue();
		SA.assertAll();
	}
}
