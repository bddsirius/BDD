package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class SignInPage extends BasePage {

	@FindBy(id="WC_AccountDisplay_FormInput_logonId_In_Logon_1")
    private BaseElement signInEmail;
	
	@FindBy(id="WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")
    private BaseElement signInPassword;
	
	@FindBy(id="WC_AccountDisplay_links_2")
    private BaseElement signInButton;
	
	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_email1_In_Register_1")
	private BaseElement regEmailInput;

	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1")
	private BaseElement regPassword;

	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1")
	private BaseElement regConfirm;

	@FindBy(id = "WC_UserRegistrationAddForm_links_1")
	private BaseElement regButton;
	
	@FindBy(id="WC_AccountDisplay_links_1")
	private BaseElement forgotPassword;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignInPage.class);
	
	/**
	 * Method to enter value in email field for SignIn
	 * @param input - Email Address
	 */
	private void inputSignInEmail(String input) {
		LOGGER.info("Entering Email: " + input);
		signInEmail.clear();
		signInEmail.sendKeys(input);
	}

	/**
	 * Method to enter value in password field for SignIn
	 * @param input - Password
	 */
	public void inputSignInPassword(String input) {
		LOGGER.info("Entering Password: " + input);
		signInPassword.clear();
		signInPassword.sendKeys(input);
	}

	/**
	 * Method to click SignIn Button
	 */
	public void clickSignInButton() {
		LOGGER.info("Clicking SignIn button");
		signInButton.click();
	}

	/**
	 * Method to SignIn using provided email address and password
	 * @param email - Email Address
	 * @param password - Password
	 */
	public void accountSignIn(String email, String password) {
		LOGGER.info("Signing In using Email: " + email + " , and Password: " + password);
		inputSignInEmail(email);
		inputSignInPassword(password);
		clickSignInButton();
	}
	
	/**
	 * Method to enter value in email field for Registration
	 * @param input - Email Address
	 */
	protected void inputRegEmail(String input) {
		LOGGER.info("Entering Email: " + input);
		regEmailInput.sendKeys(input);
	}

	/**
	 * Method to enter value in password field for Registration
	 * @param input - Password
	 */
	protected void inputRegPassword(String input) {
		LOGGER.info("Entering Password: " + input);
		regPassword.sendKeys(input);
	}

	/**
	 * Method to enter value in confirm password field for Registration
	 * @param input - Confirm Password
	 */
	protected void inputRegConfirm(String input) {
		LOGGER.info("Entering Confirm Password: " + input);
		regConfirm.sendKeys(input);
	}

	/**
	 * Method to click Register button
	 */
	protected void clickRegButton() {
		LOGGER.info("Clicking Register button");
		regButton.click();
	}

	/**
	 * Method to register using provided email address and password
	 * @param email - Email Address
	 * @param password - Password
	 */
	public void registerAccount(String email, String password) {
		inputRegEmail(email);
		inputRegPassword(password);
		inputRegConfirm(password);
		clickRegButton();
	}
	
	/**
	 * Method to verify provided error message is displayed on sign in page
	 * @param error - Error Message
	 */
	public void verifySignInError(String error) {
		assertThat(verifyErrorExists(error)).as("SignIn Page Error").isTrue();
	}
	
	public void clickForgotPassword() {
		forgotPassword.click();
	}
	
	public void verifyOnSignInPage()
	{
		assertThat(signInEmail.exists()).isTrue();
	}

}