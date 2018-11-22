package com.qualitest.pvh.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class AccountSummaryPage extends BasePage{
		
	@FindBy(id="headerLogout")
	private BaseElement logOutMenu;
	
	@FindBy(xpath="//a[@title='Sign Out']")
	private BaseElement signOut;
	
	@FindBy(id="WC_MyAccountCenterLinkDisplay_div_38")
	private BaseElement welcome;
	
	@FindBy(id="WC_MyAccountCenterLinkDisplay_inputs_1")
	private BaseElement edit;
	
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_2")
	private BaseElement myOrders;
	
	@FindBy(xpath="//*[@id='logoutMenu']/div[2]/a")
	private BaseElement myOrdersThruDropDown;

	@FindBy(id="WC_MyAccountSidebarDisplayf_links_5")
	private BaseElement myAddressBook;
	
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_6")
	private BaseElement checkoutPreferences;
	
	@FindBy(xpath = "WC_UserRegistrationAddForm_links_2")
	private BaseElement goToAccount;
	
	@FindBy(xpath = "//*[@id='WC_MyAccountCenterLinkDisplay_div_5']//*[contains (text(), 'Address')]")
	private BaseElement savedAddressInformation;
	

	private SoftAssertions SA = new SoftAssertions();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountSummaryPage.class);
	
	/**
	 * Method to verify account summary page title
	 */
	public abstract void verifyPageTitle(); 
	
	/**
	 * Method to click edit link
	 */
	public void clickEdit() {
		LOGGER.info("Clicking edit link and navigating to Personal Information Page");
		edit.click();
	}
	
	/**
	 * Method to click logout link
	 */
	public void clickLogout() {
		LOGGER.info("Clicking LogOut link");
		getDriver().navigate().refresh();
		Actions actions = new Actions(getDriver());
		actions.moveToElement(logOutMenu);
		actions.moveToElement(signOut);
		actions.click().build().perform();
	}
	
	public void navigateToMyOrders() {
		LOGGER.info("Navigating to my orders...");
		if(myOrders.exists())
		{
			myOrders.click();
		}
		else
		{
			myOrdersThruDropDown.click();
		}
		//myOrders.click();
	}
	
	public void navigateToMyAddressBook() {
		LOGGER.info("Navigating to user address book...");
		myAddressBook.click();
	}
	
	public void navigateToCheckoutPreferences() {
		LOGGER.info("Navigating to user checkout preferences...");
		checkoutPreferences.click();
	}
	
	public void verifyNoSavedAddress() {
		LOGGER.info("Verifying that no address is saved in new account...");
		SA.assertThat(savedAddressInformation.exists()).isEqualTo(false);
		SA.assertAll();
	}
	
	public void verifySavedAddress() {
		LOGGER.info("Verifying that address is saved in new account...");
		SA.assertThat(savedAddressInformation.exists()).isEqualTo(true);
		SA.assertAll();
	}

	
}