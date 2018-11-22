package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

import static org.assertj.core.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpeedoAccountSummaryPage extends AccountSummaryPage {
	
	@FindBy(xpath="//*[@id=\"siteMessageBarWrapper\"]/div[1]/a[3]")
	private BaseElement logOut;
	
	@FindBy(id="WC_MyAccountCenterLinkDisplay_inputs_1")
	private BaseElement edit;
	
	@FindBy(xpath = "//*[@value = 'SUBSCRIBE']")
	private BaseElement subscribeFooterButton;
	
	@FindBy(xpath = "//div[@id = 'footerSubscribe']//input[@id= 'signUpEmail']")
	private BaseElement newsletterEmailSignUpInput;
	
	@FindBy(xpath = "//*[@class = 'capture_message right']//*[@id= 'signUpError']")
	private BaseElement footerPageErrorMessage;
	
	@FindBy(xpath = "//*[@id = 'signUpSuccess']")
	private BaseElement footerPageSuccessMessage;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoAccountSummaryPage.class);
	
	/**
	 * Method to click edit button on Speedo account summary page
	 */
	public void clickEdit() {
		LOGGER.info("Navigating to Personal information page");
		edit.click();
	}
	
	/**
	 * Method to click logout button on Speedo account summary page
	 */
	public void clickLogOut() {
		LOGGER.info("Logging out");
		logOut.click();
	}
	
	/**
	 * Method to verify Speedo account summary page title
	 */
	@Override
	public void verifyPageTitle() {
		String title = this.getTitle();
		assertThat(title).as("Account Summary Page Title").isEqualTo("Account Summary | Speedo USA");		
	}
	
	private void clickSubscribeNewsLetterFooter() {
		LOGGER.info("Clicking the subscribe button for my account newsletter");
		subscribeFooterButton.click();
	}
	
	private void enterNewsLetterEmail(String email) {
		LOGGER.info("Entering and submitting email: "+email);
		newsletterEmailSignUpInput.type(email);
	}
	
	public void enterNewLetterAndSubmit(String email) {
		enterNewsLetterEmail(email);
		clickSubscribeNewsLetterFooter();
	}
	
	private String getFooterSignUpErrorText() {
		String s = footerPageErrorMessage.getText();
		LOGGER.info("The text of the footer error message is: "+s);
		return s;
	}
	
	public void verifyNoEmailNewsLetterSignUpOnAccount(String error) {
		assertThat(getFooterSignUpErrorText()).as("Footer error").isEqualToIgnoringCase(error);
	}
	
	private String getFooterSuccessMessage() {
		String s = footerPageSuccessMessage.getText();
		LOGGER.info("Getting the footer success message as: "+s);
		return s;
	}
	
	private boolean footerPageSuccessMessageExists() {
		boolean itExists = false;
		try {
			itExists = footerPageSuccessMessage.isVisible();
		}catch(Exception e) {}
		LOGGER.info("footerMessage success if there "+itExists);
		return itExists;	
	}
	
	public void verifyEmailNewsLetterSignUpOnAccount() {
		LOGGER.debug("Footer success message is: "+getFooterSuccessMessage());
		assertThat(footerPageSuccessMessageExists()).as("Email newsletter sign up success").isTrue();
	}
	
	
	
}