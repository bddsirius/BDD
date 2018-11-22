package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class THAccountSummaryPage extends AccountSummaryPage {
	
	@FindBy(xpath="//*[@id=\"headerLinks\"]/div[2]/a[1]")
	private BaseElement logOut;
	
	@FindBy(id="WC_MyAccountCenterLinkDisplay_inputs_1")
	private BaseElement edit;
	
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_7")
	private BaseElement Wishlist;
	
	@FindBy(xpath = "//*[@class = 'newsletterSignup']")
	private BaseElement newLetterSignUpFooter;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THAccountSummaryPage.class);
	
	/**
	 * Method to click edit link
	 */
	public void clickEdit() {
		LOGGER.info("Navigating to Personal information page...");
		edit.click();
	}
	
	/**
	 * Method to click logout link
	 */
	public void clickLogOut() {
		LOGGER.info("Logging out....");
		getDriver().navigate().refresh();
		logOut.click();
	}
	
	/**
	 * Method to verify Tommy Hilfiger account summary page
	 */
	@Override
	public void verifyPageTitle() {
		String title = this.getTitle();
		assertThat(title).as("Account Summary Page Title").isEqualTo("Account Summary | Tommy Hilfiger");
	}
	
	public void goToWishlist() {
		Wishlist.click();
	}
	
	public void clickNewsLetterSignUp() {
		LOGGER.info("Clicking the newsletter in the footer.");
		sleep(3000);
		newLetterSignUpFooter.click();
	}
	
}