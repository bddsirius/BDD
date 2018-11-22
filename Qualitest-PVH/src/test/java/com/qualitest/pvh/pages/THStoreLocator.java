package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class THStoreLocator extends StoreLocator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THStoreLocator.class);
	
	@FindBy(xpath = "//*[@class='errormap']")
	private BaseElement noresultMessage;
	
	/**
	 * Method to switch focus to store locator frame
	 */
	public void switchFocusToStoreLocator() {
		LOGGER.info("Switching focus to Store Locator Frame");
		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@title='storelocator']")));
	}
	
	/**
	 * Method to verify no search result error message
	 * @param message - Expected No search result error message
	 */
	public void verifyNoResultError(String message) {
		LOGGER.info("Verifying no search result message");
		assertThat(noresultMessage.getText().toUpperCase()).as("No Result Error Message").contains(message.toUpperCase());
	}
	
	/**
	 * Method to verify valid search result map is displayed
	 */
	public void verifyStoreLocatorResult(String location) {
		LOGGER.info("Verifying valid search result is displayed");
		try {
			if(noresultMessage.isDisplayed()) {
				assertThat(noresultMessage.isDisplayed()).as("No Search Result Message").isFalse();
			}
		} catch (Exception e) {
			verifySearchLocation(location);
		}
	}
	
}
