package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class GoogleSignInPage extends BasePage{
	
	@FindBy(xpath = "//*[@id = 'identifierId']")
	private BaseElement emailInput;
	
	@FindBy(xpath = "//*[@id = 'identifierNext']")
	private BaseElement emailNextButton;
	
	@FindBy(xpath = "//*[@name = 'password']")
	private BaseElement passwordInput;
	
	@FindBy(id = "passwordNext")
	private BaseElement passwordNextButton;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(GoogleSignInPage.class);

	public void enterEmail(String email) {
		LOGGER.info("Typing "+email+" into the email field");
		emailInput.type(email);
	}
	
	public void clickEmailNextButton() {
		LOGGER.info("Clicking the email next button");
		emailNextButton.click();
	}
	
	public void enterPassword(String password) {
		LOGGER.info("Typing in "+password+" into the password field");
		passwordInput.type(password);
	}
	
	public void clickPasswordNextButton() {
		LOGGER.info("Clicking the password next button");
		passwordNextButton.click();
	}
	
	public void signIn(String email, String password, int num) {
		
		if(num <= 0) {
			LOGGER.info("Not waiting for email to come");
		}else {
			waitForThisTime(num);
		}
		
		enterEmail(email);
		clickEmailNextButton();
		enterPassword(password);
		clickPasswordNextButton();
	}
	
	public void waitForThisTime(int num) {
		
		LOGGER.info("Waiting for "+ num + " seconds");
		
		int sleep = num *1000;
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
