package com.qualitest.pvh.pages;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class PaypalHomePage extends BasePage{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaypalHomePage.class); 
	
	@FindBy(xpath = "//*[@id=\"loginSection\"]/div/div[2]/a")
	private BaseElement logIn;
	
	/**
	 * Method to click log in button on PayPal home page
	 */
	public void clickLogin() {
		LOGGER.info("Navigating Paypal Sign In page");
		logIn.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible().click();
	}

}
