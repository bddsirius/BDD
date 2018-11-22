package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoRegisterAtCheckOutPage extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoRegisterAtCheckOutPage.class);
	
	@FindBy(id = "WC_GuestUserRegForm_FormInput_email1_In_Register_1")
	private BaseElement emailInput;
	
	@FindBy(id = "WC_GuestUserRegForm_FormInput_logonPassword_In_Register_1")
	private BaseElement passwordInput;
	
	@FindBy(id = "WC_GuestUserRegForm_FormInput_logonPasswordVerify_In_Register_1")
	private BaseElement confirmInput;
	
	@FindBy(id = "WC_GuestUserRegForm_links_1")
	private BaseElement registerButton;
	
	public void enterEmail(String email) {
		LOGGER.info("Entering email: "+email);
		emailInput.type(email);
	}
	public void enterPassword(String password) {
		LOGGER.info("Entering password: "+password);
		passwordInput.type(password);
	}
	public void enterConfirm(String password) {
		LOGGER.info("Entering confirm: "+password);
		confirmInput.type(password);
	}
	public void clickRegister() {
		LOGGER.info("Clicking register");
		registerButton.click();
	}
	public void registerAtCheckOut(String password) {
		LOGGER.info("Filling out fields and submitting account");
		enterPassword(password);
		enterConfirm(password);
		clickRegister();
	}
	
}
