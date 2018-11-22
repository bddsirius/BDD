package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoSignInPage extends CKSignInPage {

	@FindBy(id = "WC_AccountDisplay_links_3")
	private BaseElement CreateAccountButton;

	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoSignInPage.class);

	/**
	 * Method to click create account button
	 */
	public void clickCreateAccountButton() {
		LOGGER.info("Clicking Create Acount button");
		CreateAccountButton.click();
	}

}