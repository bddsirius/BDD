package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class AccountUpdateConfirmationPage extends BasePage{
	
	@FindBy(xpath = "//*[@id=\"WC_MyAccountCenterLinkDisplay_div_6\"]/div[1]")
	protected BaseElement promptHeader;
	
	@FindBy(id = "WC_UserRegistrationAddForm_links_2")
	private BaseElement goToAccountButton;
	
	@FindBy(id = "WC_UserRegistrationAddForm_links_2")
	private BaseElement continueShoppingButton;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountUpdateConfirmationPage.class);
	
	/**
	 * Method to click go to account button
	 */
	public void clickGoToAccount() {
		LOGGER.info("Clicking Go to Account Button");
		goToAccountButton.click();
	}
	
	/**
	 * Method to click continue shopping button
	 */
	public void clickContinueShopping() {
		LOGGER.info("Clicking Continue Shopping Button");
		continueShoppingButton.click();
	}
	
	/**
	 * Method to verify title of account update confirmation page
	 */
	public abstract void verifyPageTitle();

}