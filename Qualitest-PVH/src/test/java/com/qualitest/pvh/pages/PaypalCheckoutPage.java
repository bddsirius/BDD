package com.qualitest.pvh.pages;

import com.qualitest.core.page.BasePage;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class PaypalCheckoutPage extends BasePage{

	public static final Logger LOGGER = LoggerFactory.getLogger(PaypalCheckoutPage.class);
	
	@FindBy(xpath = "//*[@id='confirmButtonTop']")
	private BaseElement payNow;
	
	/**
	 * Method to click pay now button on PayPal checkout page
	 */
	public void clickPayNow() {
		LOGGER.info("Clicking Pay Now button");
		payNow.withTimeoutOf(1, TimeUnit.MINUTES).waitUntilVisible().click();
	}
	
}
