package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class THSignInPage extends SignInPage {

	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_rememberMe_In_Register_1")
	private BaseElement termsAndCondButton;

	@FindBy(xpath = "//*[@id=\"SignupLoyaltyMemberField\"]/div[1]/a")
	private BaseElement existingMemberExpandButton;

	@FindBy(id = "WC_UserRegistrationAddForm_FormInput_userProfileField1_In_Register_1")
	private BaseElement membershipNumInput;

	@FindBy(id = "forgotPPN")
	private BaseElement forgetIDButton;

	@FindBy(id = "fieldErrorMessage")
	private BaseElement errorMessageUnderRegister;

	private static final Logger LOGGER = LoggerFactory.getLogger(THSignInPage.class);

	/**
	 * Method to enter value in member id field
	 * @param member - Member Id
	 */
	public void inputMemberID(String member) {
		LOGGER.info("Entering Member ID: " + member);
		membershipNumInput.type(member);
	}

	/**
	 * Method to click terms and condition check box
	 */
	public void clickAgree() {
		LOGGER.info("Accepting Terms and Condition");
		termsAndCondButton.click();
	}

	/**
	 * Method to enable existing member id field
	 */
	public void clickMemberExpand() {
		LOGGER.info("Enabling Hilfiger Member Id field");
		existingMemberExpandButton.click();
	}

	/**
	 * Method to click forgot member id link
	 */
	public void clickForgotID() {
		LOGGER.info("Clicking Forget Member ID");
		forgetIDButton.click();
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
		clickAgree();
		clickRegButton();
	}
	
}