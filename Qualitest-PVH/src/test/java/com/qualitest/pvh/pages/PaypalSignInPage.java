package com.qualitest.pvh.pages;

import com.qualitest.core.page.BasePage;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PaypalSignInPage extends BasePage{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PaypalSignInPage.class);
	
	@FindBy(xpath = "//*[@id='email']")
	private BaseElement emailField;
	
	@FindBy(xpath = "//*[@id='password']")
	private BaseElement passwordField;
	
	@FindBy(id="btnNext")
	private BaseElement next;
	
	@FindBy(xpath = "//*[@id='btnLogin']")
	private BaseElement login;
	
	/**
	 * Method to enter provided email address on PayPal Sign In page
	 * @param email - PayPal Email Address
	 */
	private void typeEmail(String email) {
		pageRefresh();
		LOGGER.info("Entering email: " + email);
		emailField.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible().type(email);
	}
	
	/**
	 * Method to enter provided password on PayPal Sign In page
	 * @param password - PayPal password
	 */
	private void typePassword(String password) {
		LOGGER.info("Entering password: " + password);
		passwordField.type(password);
	}
	
	/**
	 * Method to click Log In button on PayPal Sign In page
	 */
	private void clickLogin() {
		LOGGER.info("Clicking Log In button");
		login.click();
	}
	
	/**
	 * Method to sign in using provided PayPal account
	 * @param email - PayPal email address
	 * @param password - PayPal password
	 */
	public void loginToPaypal(String email, String password) {
		typeEmail(email);
		typePassword(password);
		clickLogin();
	}
	
}
