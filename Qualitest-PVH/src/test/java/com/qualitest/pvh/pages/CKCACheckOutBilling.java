package com.qualitest.pvh.pages;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CKCACheckOutBilling extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(CKCACheckOutBilling.class);
	
	@FindBy(xpath = "//*[@id = 'KKnr']")
	private BaseElement cardNumber;
	
	@FindBy(id = "KKMonth")
	private BaseElement expMonth;
	
	@FindBy(id = "KKYear")
	private BaseElement expYear;
	
	@FindBy(id = "CCCVC")
	private BaseElement cvv;
	
	@FindBy(id = "CreditCardHolder")
	private BaseElement nameOnCard;
	
	@FindBy(id = "Terms")
	private BaseElement agreement;
	
	@FindBy(id = "paymentCommit")
	private BaseElement submitPayment;
	
	
	private void switchFrameToBillingInfo() {
		LOGGER.info("Switching frames to billing information");
		getDriver().switchTo().frame("paymentiframe");
		getDriver().switchTo().frame("paymentFrame");
	}
	
	private void enterCardNumber(String number) {
		LOGGER.info("Entering the card number "+ number + " into the card number field");
		cardNumber.type(number);
	}
	private void selectExpMonth(String month) {
		LOGGER.info("Selecting the Experation month as "+month);
		Select roledown = new Select(expMonth);
		roledown.selectByVisibleText(month);
	}
	private void selectExpYear(String year) {
		LOGGER.info("Selecting the experation year as "+year);
		Select roledown = new Select(expYear);
		roledown.selectByVisibleText(year);
	}
	private void enterCVV(String text) {
		LOGGER.info("Entering the cvv as "+ text + " in the cvv field");
		cvv.type(text);
	}
	private void enterNameOnCard(String name) {
		LOGGER.info("Entering the name "+name+ " in the card holder name field");
		nameOnCard.type(name);
	}
	private void clickAgreement() {
		LOGGER.info("Clicking the terms and agreement field");
		agreement.click();
	}
	public void clickSubmit() {
		LOGGER.info("Clicking the submit button");
		submitPayment.click();
	}

	
	public void enteringBillingInformation(String number, String month, String year, String cvv, String name) {
		switchFrameToBillingInfo();
		enterCardNumber(number);
		selectExpMonth(month);
		selectExpYear(year);
		enterCVV(cvv);
		enterNameOnCard(name);
		clickAgreement();
		clickSubmit();
	}
	
	
	
}
